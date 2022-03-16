package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:54
 */


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Budget extends Model<Budget> {
    private int budgetId;
    private String declarationId;
    private String declarationName;
    private String declarationType;
    private String unitId;
    private String unitName;
    private String userIdApply;
    private String userNameApply;
    private String userCellphoneApply;
    private DateTime declarationDate;
    private String declarationCategoryId;
    private String declarationCategoryName;
    private String declarationReason;
    private Double declarationAmount;
    private String unitPrincipalIdApply;
    private String unitPrincipalNameApply;
    private String programPrincipalId;
    private String programPrincipalName;
    private String budgetSource;
    private String budgetYear;
    private String budgetMark;
    private String budgetCustomField1;
    private String budgetCustomField2;
    private String budgetCustomField3;
    private Double budget_custom_num1;
    private Double budget_custom_num2;
    private DateTime budget_custom_date;

    //乐观锁
    //private int version;
    //逻辑删除
    //private int deleted;
}
