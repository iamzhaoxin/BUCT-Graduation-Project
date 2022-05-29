package buct.budgetsystem.service;

import buct.budgetsystem.dao.DeclarationDao;
import buct.budgetsystem.dao.FlowDao;
import buct.budgetsystem.dao.UserDao;
import buct.budgetsystem.pojo.entity.*;
import buct.budgetsystem.pojo.vo.ProcessUsing;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

@Service
@Slf4j
public class FlowService extends ServiceImpl<FlowDao, Flow> {

    private final ProcessEngine processEngine;
    private final FlowDao flowDao;
    private final DeclarationDao declarationDao;
    private final UserDao userDao;
    private final DeclarationService declarationService;
    private final DeclarationDetailService declarationDetailService;
    private final BudgetService budgetService;
    private final BudgetInventoryService budgetInventoryService;

    public FlowService(ProcessEngine processEngine, FlowDao flowDao, DeclarationDao declarationDao, UserDao userDao, DeclarationService declarationService, DeclarationDetailService declarationDetailService, BudgetService budgetService, BudgetInventoryService budgetInventoryService) {
        this.processEngine = processEngine;
        this.flowDao = flowDao;
        this.declarationDao = declarationDao;
        this.userDao = userDao;
        this.declarationService = declarationService;
        this.declarationDetailService = declarationDetailService;
        this.budgetService = budgetService;
        this.budgetInventoryService = budgetInventoryService;
    }

    public String deployZIP(InputStream inputStream, String name) {
        ZipInputStream zip = new ZipInputStream(inputStream);
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addZipInputStream(zip)
                .name(name)
                .deploy();
        return deployment.getName();
    }


    public ProcessDefinition[] getAllProcess() {
        List<ProcessDefinition> processDefinitions = processEngine.getRepositoryService()
                .createProcessDefinitionQuery()
                .list();
        return processDefinitions.toArray(new ProcessDefinition[0]);
    }

    public ProcessDefinition getProcessById(String id) {
        return processEngine.getRepositoryService()
                .createProcessDefinitionQuery()
                .processDefinitionId(id)
                .singleResult();
    }

    public File getProcessBpmnByName(String bpmnName) {
        return flowDao.getBpmnByName(bpmnName);
    }

    public File getProcessPngByName(String diagramResourceName) {
        return flowDao.getPngByName(diagramResourceName);
    }

    public void deleteProcessById(String id) {
        ProcessDefinition processDefinition = processEngine.getRepositoryService()
                .createProcessDefinitionQuery()
                .processDefinitionId(id)
                .singleResult();
        // 第二个参数true 递归删除
        processEngine.getRepositoryService().deleteDeployment(processDefinition.getDeploymentId(), true);
    }

    public void startProcessInstance(Integer businessId) {
        Map<String, Object> map = new HashMap<>();
//        map.put("approver1", "2018040437");
//        map.put("approver2", "2018040438");
//        map.put("approver3", "2018040439");
//        map.put("approver4", "2018040440");
        int index=1;
        for(String userId:ProcessUsing.approverId){
            String assignee="approver"+index;
            System.out.println(assignee);
            index++;
            map.put(assignee,userId);
        }
        processEngine.getRuntimeService()
                .startProcessInstanceByKey(ProcessUsing.process.get("key"), String.valueOf(businessId), map);
    }


    public void removeByDeclarationId(Integer declarationId) {
        flowDao.removeByDeclarationId(declarationId);
    }

    public String getStatusByDeclarationId(String declarationId) {
        return flowDao.getStatusByDeclarationId(declarationId);
    }

    public ArrayList<HashMap<String,Object>> getTasksByAssigneeId(Integer userId) {
        TaskQuery taskQuery = processEngine.getTaskService().createTaskQuery().taskAssignee(String.valueOf(userId));
        List<Task> list = taskQuery.orderByTaskCreateTime().desc().list();
        ArrayList<HashMap<String,Object>> arrayList=new ArrayList<>();
        for (Task task : list) {
            ProcessInstance processInstance = processEngine.getRuntimeService()
                    .createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult();
            String declarationId = processInstance.getBusinessKey();
            //判断申请是否被撤销
            if (declarationDao.selectById(declarationId) == null) {
                processEngine.getRuntimeService().deleteProcessInstance(task.getProcessInstanceId(),"");
            } else {
                HashMap map=new HashMap<>();
                map.put("declaration",declarationService.getById(declarationId));
                map.put("asset",declarationDetailService.getDetailByDeclarationId(Integer.valueOf(declarationId)));
                map.put("processInstanceId",task.getProcessInstanceId());
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    public void refuseTaskByDeclarationId(String processInstanceId,String suggestion,Integer userId) {
        ProcessInstance processInstance = processEngine.getRuntimeService()
                .createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        String declarationId = processInstance.getBusinessKey();
        String userName=userDao.selectById(userId).getUserName();

        processEngine.getRuntimeService().deleteProcessInstance(processInstanceId,"");

        flowDao.refuseDeclarationById(declarationId,suggestion,userId,userName);
    }

    public void agreeTaskByDeclarationId(String processInstanceId,String suggestion,Integer userId) {
        ProcessInstance processInstance = processEngine.getRuntimeService()
                .createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        String declarationId = processInstance.getBusinessKey();
        String userName=userDao.selectById(userId).getUserName();

        Task task = processEngine.getTaskService().createTaskQuery().processInstanceId(processInstanceId).singleResult();
        processEngine.getTaskService().complete(task.getId());

        flowDao.agreeDeclarationById(declarationId,suggestion,userId,userName);

        // 在ACT_RU_TASK表中查找ID_，如果没有，说明流程执行完成，将数据保存到Budget表中
        if(flowDao.findActRuTaskByID(task.getId())==null){
            log.info("流程执行完成");
            flowDao.finishDeclarationById(declarationId,suggestion,userId,userName);

            // 将数据保存到ys_budget和ys_budget_inventory表中
            Declaration declaration=declarationService.getById(declarationId);
            DeclarationDetail declarationDetail=declarationDetailService.getDetailByDeclarationId(Integer.valueOf(declarationId));

            Budget budget=new Budget();
            budget.setBudgetId(null);
            budget.setDeclarationId(declaration.getDeclarationId());
            budget.setDeclarationName(declaration.getDeclarationName());
            budget.setDeclarationType(declaration.getDeclarationType());
            budget.setUnitId(declaration.getUnitId());
            budget.setUnitName(declaration.getUnitName());
            budget.setUserIdApply(declaration.getUserIdApply());
            budget.setUserNameApply(declaration.getUserNameApply());
            budget.setUserCellphoneApply(declaration.getUserCellphoneApply());
            budget.setDeclarationDate(declaration.getDeclarationDate());
            budget.setDeclarationCategory(declaration.getDeclarationCategory());
            budget.setDeclarationReason(declaration.getDeclarationReason());
            budget.setDeclarationAmount(declarationDetail.getDetailAssetCount()*declarationDetail.getDetailAssetPrice());
            budget.setUnitPrincipalIdApply(declaration.getUnitPrincipalIdApply());
            budget.setUnitPrincipalNameApply(declaration.getUnitPrincipalNameApply());
            budget.setProgramPrincipalId(declaration.getProgramPrincipalId());
            budget.setProgramPrincipalName(declaration.getProgramPrincipalName());
            budget.setBudgetSource(declaration.getBudgetSource());
            budget.setBudgetYear(declaration.getBudgetYear());
            budget.setBudgetMark(declaration.getDeclarationRemark());
            budgetService.save(budget);

            BudgetInventory budgetInventory=new BudgetInventory();
            budgetInventory.setInventoryId(null);
            budgetInventory.setDeclarationId(declaration.getDeclarationId());
            budgetInventory.setDeclarationName(declaration.getDeclarationName());
            budgetInventory.setDetailAssetId(declarationDetail.getDetailAssetId());
            budgetInventory.setDetailAssetName(declarationDetail.getDetailAssetName());
            budgetInventory.setUnitId(declaration.getUnitId());
            budgetInventory.setUnitName(declaration.getUnitName());
            budgetInventory.setStorage(declarationDetail.getStorageName());
            budgetInventory.setDetailAssetModel(declarationDetail.getDetailAssetModel());
            budgetInventory.setDetailAssetSpec(declarationDetail.getDetailAssetSpec());
            budgetInventory.setDetailAssetCount(declarationDetail.getDetailAssetCount());
            budgetInventory.setDetailAssetUnit(declarationDetail.getDetailAssetUnit());
            budgetInventory.setDetailAssetPrice(declarationDetail.getDetailAssetPrice());
            budgetInventory.setInventoryMark(declarationDetail.getDetailMark());
            budgetInventoryService.save(budgetInventory);
        }
    }
}
