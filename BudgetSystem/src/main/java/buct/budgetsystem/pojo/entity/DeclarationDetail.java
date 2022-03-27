package buct.budgetsystem.pojo.entity;

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
     * 主键id
     */
    @TableId
    private Integer detailId;
    /**
     * 经费申请编号
     */
    private String declarationId;
    /**
     * 经费申请名称
     */
    private String declarationName;
    /**
     * 资产编号
     */
    private String detailAssetId;
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
     * 资产存放地点id
     */
    private String storageId;
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
}
