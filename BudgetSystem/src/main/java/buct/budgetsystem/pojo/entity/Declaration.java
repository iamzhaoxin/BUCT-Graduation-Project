package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:54
 */


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Declaration extends Model<Declaration> {
    private String declarationId;
    private String declarationName;
    private String declarationType;
    private String unitId;
    private String unitName;
    private String userIdApply;
    private String userNameApply;
    private String userCellphoneApply;
    private DateTime declarationDate;
    private String declarationState;
    private String declarationCategoryId;
    private String declarationCategoryName;
    private String declarationReason;
    private Double declarationAmount;
    private String unitPrincipalIdApply;
    private String unitPrincipalNameApply;
    private String declarationIsImport;
    private String programPrincipalId;
    private String programPrincipalName;
    private String budgetSource;
    private String budgetYear;
    private String declarationRemark;
    private String declarationCustomField1;
    private String declarationCustomField2;
    private String declarationCustomField3;
    private Double declarationCustomNumber1;
    private Double declarationCustomNumber2;
    private Double declarationCustomNumber3;
    private DateTime declarationCustomDate1;
    private DateTime declarationCustomDate2;
}
