package buct.budgetsystem.controller;

import buct.budgetsystem.dao.UnitDao;
import buct.budgetsystem.dao.UserDao;
import buct.budgetsystem.pojo.entity.Declaration;
import buct.budgetsystem.pojo.entity.DeclarationDetail;
import buct.budgetsystem.pojo.entity.Flow;
import buct.budgetsystem.pojo.vo.Result;
import buct.budgetsystem.service.DeclarationDetailService;
import buct.budgetsystem.service.DeclarationService;
import buct.budgetsystem.service.FlowService;
import buct.budgetsystem.service.UnitService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping("/budget")
@Slf4j
public class DeclarationController {

    private final DeclarationService declarationService;
    private final DeclarationDetailService declarationDetailService;
    private final UnitService unitService;
    private final UserDao userDao;
    private final UnitDao unitDao;
    private final FlowService flowService;

    public DeclarationController(DeclarationService declarationService, DeclarationDetailService declarationDetailService, UnitService unitService, UserDao userDao, UnitDao unitDao, FlowService flowService) {
        this.declarationService = declarationService;
        this.declarationDetailService = declarationDetailService;
        this.unitService = unitService;
        this.userDao = userDao;
        this.unitDao = unitDao;
        this.flowService = flowService;
    }





    @PostMapping("/insert")
    public Result insertDeclaration(@RequestBody JSONObject budgetData){
        System.out.println("开始提交: "+budgetData.getString("applyName"));
        Declaration declaration=new Declaration(
                null,budgetData.getString("applyName"),budgetData.getString("applyType"),
                unitService.getIdByName(budgetData.getString("applyUnit")),
                budgetData.getString("applyUnit"),budgetData.getString("applyUserId"),
                budgetData.getString("applyName"),userDao.getUserPhoneById(budgetData.getString("applyUserId")),
                budgetData.getDate("applyDate"),"0",budgetData.getString("applyCategory"),
                budgetData.getString("applySeason"),budgetData.getDouble("applyAmount"),
                unitDao.getUnitPrincipalIdByUnitName(budgetData.getString("applyUnit")),
                unitDao.getUnitPrincipalNameByUnitName(budgetData.getString("applyUnit")),
                budgetData.getString("ifImport"),budgetData.getString("programPrincipalId"),
                userDao.getUserNameById("programPrincipalId"),budgetData.getString("amountFrom"),
                budgetData.getString("amountYear"),budgetData.getString("applyRemark")
        );
        declarationService.saveOrUpdate(declaration);

        DeclarationDetail declarationDetail=new DeclarationDetail(
                null,declaration.getDeclarationId(), declaration.getDeclarationName(),
                budgetData.getString("detailAssetName"), declaration.getUnitId(),declaration.getUnitName(),
                budgetData.getString("detailAssetModel"),budgetData.getString("detailAssetSpec"),
                budgetData.getString("storage"), budgetData.getDouble("detailAssetCount"),
                budgetData.getString("detailAssetUnit"), budgetData.getDouble("detailAssetPrice"),
                budgetData.getString("detailRemark")
        );
        declarationDetailService.saveOrUpdate(declarationDetail);

        // 开启审批流
        flowService.startProcessInstance(declaration.getDeclarationId());

        // 记录到Flow表
        Flow flow=new Flow(null, declaration.getDeclarationId(),null,null,
                new SimpleDateFormat("yyyy-MM-dd").format(new Date()),"提出申请","未审");
        flowService.save(flow);

        return new Result(200,"success",null,null);
    }

    @GetMapping("/delete")
    public Result deleteDeclaration(@RequestParam Integer declarationId){
        Integer assetId=declarationDetailService.getAssetIdByDeclarationId(declarationId);
        declarationService.removeById(declarationId);
        declarationDetailService.removeById(assetId);
        flowService.removeByDeclarationId(declarationId);
        return new Result(200,"success",null,null);
    }

    @GetMapping("/ones")
    public Result getOnesAllDeclaration(@RequestParam Integer userId){
        Integer[] declarationIds=declarationService.getIdsByUserId(userId);
        ArrayList<HashMap<String,Object>> arrayList=new ArrayList<>();
        for(Integer declarationId : declarationIds){
            HashMap map=new HashMap<>();
            map.put("declaration",declarationService.getById(declarationId));
            map.put("asset",declarationDetailService.getDetailByDeclarationId(declarationId));
            arrayList.add(map);
        }
        return new Result(200,"success",arrayList,null);
    }



}
