package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import org.joda.time.DateTime;

/**
 * 经费预算清单
 * 数据表：ys_budget_inventory
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:54
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetInventory extends Model<BudgetInventory> {
    /**
     * 经费预算清单id
     */
    @TableId
    private Long inventoryId;
    /**
     * 经费编号
     */
    private Integer declarationId;
    /**
     * 经费名称
     */
    private String declarationName;
    /**
     * 预算明细id
     */
    private int detailId;
    /**
     * 预算资产编号
     */
    private Integer detailAssetId;
    /**
     * 预算资产名称
     */
    private String detailAssetName;
    /**
     * 单位编号
     */
    private String unitId;
    /**
     * 单位名称
     */
    private String unitName;
    /**
     * 资产存放地点id
     */
    private String storageId;
    /**
     * 预算资产型号
     */
    private String detailAssetModel;
    /**
     * 预算资产规格
     */
    private String detailAssetSpec;
    /**
     * 预算资产数量
     */
    private Double detailAssetCount;
    /**
     * 预算资产计量单位
     */
    private String detailAssetUnit;
    /**
     * 预算资产单价
     */
    private Double detailAssetPrice;
    /**
     * 预算清单备注
     */
    private String inventoryMark;
    /**
     * 备用字符
     */
    private String inventoryCustomField1;
    /**
     * 备用字符
     */
    private String inventoryCustomField2;
    /**
     * 备用字符
     */
    private Double inventoryCustomNum1;
    /**
     * 备用字符
     */
    private Double inventoryCustomNum2;
    /**
     * 备用字符
     */
    private DateTime inventoryCustomDate;
}
