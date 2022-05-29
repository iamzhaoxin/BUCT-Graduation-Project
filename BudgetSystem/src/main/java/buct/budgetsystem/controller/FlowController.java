package buct.budgetsystem.controller;

import buct.budgetsystem.pojo.vo.ProcessUsing;
import buct.budgetsystem.pojo.vo.Result;
import buct.budgetsystem.service.DeclarationDetailService;
import buct.budgetsystem.service.DeclarationService;
import buct.budgetsystem.service.FlowService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/flow")
@Slf4j
public class FlowController {

    private final FlowService flowService;
    private final DeclarationService declarationService;
    private final DeclarationDetailService declarationDetailService;


    public FlowController(FlowService flowService, DeclarationService declarationService, DeclarationDetailService declarationDetailService) {
        this.flowService = flowService;
        this.declarationService = declarationService;
        this.declarationDetailService = declarationDetailService;
    }

    @PostMapping("/complete")
    public Result completeDeclarationTask(@RequestBody JSONObject suggest) {
        Integer userId=suggest.getInteger("userId");
        String status = suggest.getString("status");
        String suggestion = suggest.getString("value");
        String processInstanceId = suggest.getString("processInstanceId");

        if (status.equals("false")) {
            // 不通过，流程结束，Flow表设“驳回”
            flowService.refuseTaskByDeclarationId(processInstanceId,suggestion,userId);
        } else {
            //complete task
            flowService.agreeTaskByDeclarationId(processInstanceId,suggestion,userId);
        }

        return new Result(200, "success complete task", null, null);
    }

    //    @ResponseBody
    @PostMapping("/upload")
    public Result uploadDeployment(MultipartFile file) throws Exception {
        log.info("收到了上传的流程压缩包：" + file.getOriginalFilename());
        String deployName = flowService.deployZIP(file.getInputStream(), file.getOriginalFilename());
        return new Result(200, "add process success", deployName, null);
    }

    @GetMapping("/getAll")
    public Result getAllProcess() {
        //获得所有流程的 id, name, key, reversion, png
        ProcessDefinition[] processDefinitions = flowService.getAllProcess();

        LinkedList<HashMap<String, Object>> res = new LinkedList<>();
        for (ProcessDefinition processDefinition : processDefinitions) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("id", processDefinition.getId());
            map.put("name", processDefinition.getName());
            map.put("key", processDefinition.getKey());
            map.put("reversion", processDefinition.getVersion());

            File bpmn = flowService.getProcessBpmnByName(processDefinition.getResourceName());
            map.put("bpmn", bpmn);
            File png = flowService.getProcessPngByName(processDefinition.getDiagramResourceName());
            map.put("png", png);
            log.info("getAllProcess 查找到流程：" + map.get("name").toString());
            res.add(map);
        }
        return new Result(200, null, res, null);
    }

    @GetMapping("/use")
    public Result useProcess(@RequestParam String id) {
        ProcessDefinition processDefinition = flowService.getProcessById(id);
        new ProcessUsing();
        ProcessUsing.setProcess(processDefinition.getId(), processDefinition.getName(), processDefinition.getKey(), String.valueOf(processDefinition.getVersion()));
        return new Result(200, "选择流程成功", null, null);
    }

    @GetMapping("/using")
    public Result usingProcess() {
        String id = ProcessUsing.process.get("id");
        return new Result(200, null, id, null);
    }

    @GetMapping("/delete")
    public Result deleteProcess(@RequestParam String id) {
        flowService.deleteProcessById(id);
        return new Result(200, null, null, null);
    }

    @GetMapping("/status")
    public Result applyStatus(@RequestParam String declarationId) {
        String status = flowService.getStatusByDeclarationId(declarationId);
        return new Result(200, null, status, null);
    }

    @GetMapping("/task")
    public Result getOnesTaskDeclaration(@RequestParam Integer userId) {

        ArrayList<HashMap<String, Object>> arrayList = flowService.getTasksByAssigneeId(userId);

        return new Result(200, "success", arrayList, null);
    }

}
