package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import org.joda.time.DateTime;

import java.util.Date;


/**
 * 经费预算表
 * 数据表：ys_budget
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:54
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Budget extends Model<Budget> {
    /**
     * 经费预算id
     */
    @TableId
    private Integer budgetId;
    /**
     * 经费编号
     */
    private Integer declarationId;
    /**
     * 经费申请名称
     */
    private String declarationName;
    /**
     * 经费类别：教学（01）纵向科研（02）横向科研（03）专项（04）
     */
    private String declarationType;
    /**
     * 部门编号
     */
    private String unitId;
    /**
     * 部门名称
     */
    private String unitName;
    /**
     * 申请人编号
     */
    private String userIdApply;
    /**
     * 申请人姓名
     */
    private String userNameApply;
    /**
     * 申请人电话
     */
    private String userCellphoneApply;
    /**
     * 申请日期
     */
    private Date declarationDate;
    /**
     * 申请类别：常规类  大型仪器  科研零散类
     */
    private String declarationCategory;
    /**
     * 申请理由
     */
    private String declarationReason;
    /**
     * 预算金额（=detail_asset_count*detail_asset_price）
     */
    private Double declarationAmount;
    /**
     * 申请部门负责人工号
     */
    private String unitPrincipalIdApply;
    /**
     * 申请部门负责人姓名
     */
    private String unitPrincipalNameApply;
    /**
     * 项目负责人工号
     */
    private String programPrincipalId;
    /**
     * 项目负责人姓名
     */
    private String programPrincipalName;
    /**
     * 经费来源
     */
    private String budgetSource;
    /**
     * 预算年度
     */
    private String budgetYear;
    /**
     * 经费预算备注
     */
    private String budgetMark;
    /**
     * 备用字符
     */
    private String budgetCustomField1;
    /**
     * 备用字符
     */
    private String budgetCustomField2;
    /**
     * 备用字符
     */
    private String budgetCustomField3;
    /**
     * 备用字符
     */
    private Double budgetCustomNum1;
    /**
     * 备用字符
     */
    private Double budgetCustomNum2;
    /**
     * 备用字符
     */
    private DateTime budgetCustomNum3;

    public Budget(Integer budgetId, Integer declarationId,
                  String declarationName, String declarationType,
                  String unitId, String unitName,
                  String userIdApply, String userNameApply, String userCellphoneApply,
                  Date declarationDate, String declarationCategory, String declarationReason,
                  Double declarationAmount, String unitPrincipalIdApply,
                  String unitPrincipalNameApply, String programPrincipalId,
                  String programPrincipalName, String budgetSource, String budgetYear, String budgetMark) {
        this.budgetId = budgetId;
        this.declarationId = declarationId;
        this.declarationName = declarationName;
        this.declarationType = declarationType;
        this.unitId = unitId;
        this.unitName = unitName;
        this.userIdApply = userIdApply;
        this.userNameApply = userNameApply;
        this.userCellphoneApply = userCellphoneApply;
        this.declarationDate = declarationDate;
        this.declarationCategory = declarationCategory;
        this.declarationReason = declarationReason;
        this.declarationAmount = declarationAmount;
        this.unitPrincipalIdApply = unitPrincipalIdApply;
        this.unitPrincipalNameApply = unitPrincipalNameApply;
        this.programPrincipalId = programPrincipalId;
        this.programPrincipalName = programPrincipalName;
        this.budgetSource = budgetSource;
        this.budgetYear = budgetYear;
        this.budgetMark = budgetMark;
    }
}
