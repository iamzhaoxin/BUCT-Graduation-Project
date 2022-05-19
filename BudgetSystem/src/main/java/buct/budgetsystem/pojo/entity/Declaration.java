package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * 经费申请表
 * 数据表：ys_declaration
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:54
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Declaration extends Model<Declaration> {
    /**
     * 经费申请编号
     */
    @TableId(type = IdType.AUTO)
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
     * 审批状态：未审（0）审核中（1）审核完结（2）驳回（3）采购执行（4）合同签订（5）到货验收（6）
     */
    private String declarationState;
    /**
     * 申请类别：常规类  大型仪器  科研零散类
     */
    private String declarationCategory;
    /**
     * 申请理由
     */
    private String declarationReason;
    /**
     * 经费金额
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
     * 是否进口：国产（0）进口（1）
     */
    private String declarationIsImport;
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
     * 经费申请备注
     */
    private String declarationRemark;
    /**
     * 备用字符
     */
    private String declarationCustomField1;
    /**
     * 备用字符
     */
    private String declarationCustomField2;
    /**
     * 备用字符
     */
    private String declarationCustomField3;
    /**
     * 备用字符
     */
    private Double declarationCustomNumber1;
    /**
     * 备用字符
     */
    private Double declarationCustomNumber2;
    /**
     * 备用字符
     */
    private Double declarationCustomNumber3;
    /**
     * 备用字符
     */
    private DateTime declarationCustomDate1;
    /**
     * 备用字符
     */
    private DateTime declarationCustomDate2;

    public Declaration(Integer declarationId, String declarationName, String declarationType, String unitId,
                       String unitName, String userIdApply, String userNameApply, String userCellphoneApply,
                       Date declarationDate, String declarationState, String declarationCategory,
                       String declarationReason, Double declarationAmount, String unitPrincipalIdApply,
                       String unitPrincipalNameApply, String declarationIsImport, String programPrincipalId,
                       String programPrincipalName, String budgetSource, String budgetYear, String declarationRemark) {
        this.declarationId = declarationId;
        this.declarationName = declarationName;
        this.declarationType = declarationType;
        this.unitId = unitId;
        this.unitName = unitName;
        this.userIdApply = userIdApply;
        this.userNameApply = userNameApply;
        this.userCellphoneApply = userCellphoneApply;
        this.declarationDate = declarationDate;
        this.declarationState = declarationState;
        this.declarationCategory = declarationCategory;
        this.declarationReason = declarationReason;
        this.declarationAmount = declarationAmount;
        this.unitPrincipalIdApply = unitPrincipalIdApply;
        this.unitPrincipalNameApply = unitPrincipalNameApply;
        this.declarationIsImport = declarationIsImport;
        this.programPrincipalId = programPrincipalId;
        this.programPrincipalName = programPrincipalName;
        this.budgetSource = budgetSource;
        this.budgetYear = budgetYear;
        this.declarationRemark = declarationRemark;
    }
}
