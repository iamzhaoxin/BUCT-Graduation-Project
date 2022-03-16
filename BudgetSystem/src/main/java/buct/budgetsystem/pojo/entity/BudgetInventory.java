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
public class BudgetInventory extends Model<BudgetInventory> {

    private int inventoryId;
    private String declarationId;
    private String declarationName;
    private int detailId;
    private String detailAssetId;
    private String detailAssetName;
    private String unitId;
    private String unitName;
    private String storageId;
    private String detailAssetModel;
    private String detailAssetSpec;
    private Double detailAssetCount;
    private String detailAssetUnit;
    private Double detailAssetPrice;
    private String inventoryMark;
    private String inventoryCustomField1;
    private String inventoryCustomField2;
    private Double inventoryCustomNum1;
    private Double inventoryCustomNum2;
    private DateTime inventoryCustomDate;
}
