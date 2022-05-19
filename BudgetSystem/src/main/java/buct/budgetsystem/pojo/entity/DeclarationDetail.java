package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * 经费申请明细表
 * 数据表：ys_declaration_detail
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:54
 */



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeclarationDetail extends Model<DeclarationDetail> {
    /**
     * 资产编号
     */
    @TableId(type = IdType.AUTO)
    private Integer detailAssetId;
    /**
     * 经费申请编号
     */
    private Integer declarationId;
    /**
     * 经费申请名称
     */
    private String declarationName;
    /**
     * 资产名称
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
     * 预算资产型号
     */
    private String detailAssetModel;
    /**
     * 预算资产规格
     */
    private String detailAssetSpec;
    /**
     * 资产存放地点
     */
    private String storageName;
    /**
     * 预算资产数量
     */
    private String detailAssetCount;
    /**
     * 预算资产计量单位
     */
    private String detailAssetUnit;
    /**
     * 预算资产的单价
     */
    private String detailAssetPrice;
    /**
     * 备注
     */
    private String detailMark;
    /**
     * 备用字符
     */
    private String detailCustomField1;
    /**
     * 备用字符
     */
    private String detailCustomField2;
    /**
     * 备用字符
     */
    private String detailCustomField3;
    /**
     * 备用字符
     */
    private String detailCustomNum1;
    /**
     * 备用字符
     */
    private String detailCustomDate1;
    /**
     * 备用字符
     */
    private String detailCustomNum2;
    /**
     * 备用字符
     */
    private String detailCustomDate2;

    public DeclarationDetail(Integer detailAssetId,Integer declarationId, String declarationName,
                              String detailAssetName, String unitId,
                             String unitName, String detailAssetModel, String detailAssetSpec,
                             String storageName, String detailAssetCount, String detailAssetUnit,
                             String detailAssetPrice, String detailMark) {
        this.declarationId = declarationId;
        this.declarationName = declarationName;
        this.detailAssetId = detailAssetId;
        this.detailAssetName = detailAssetName;
        this.unitId = unitId;
        this.unitName = unitName;
        this.detailAssetModel = detailAssetModel;
        this.detailAssetSpec = detailAssetSpec;
        this.storageName = storageName;
        this.detailAssetCount = detailAssetCount;
        this.detailAssetUnit = detailAssetUnit;
        this.detailAssetPrice = detailAssetPrice;
        this.detailMark = detailMark;
    }
}
