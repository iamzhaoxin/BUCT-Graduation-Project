package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:54
 */


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeclarationDetail extends Model<DeclarationDetail> {

    private String detailId;
    private String declarationId;
    private String declarationName;
    private String detailAssetId;
    private String detailAssetName;
    private String unitId;
    private String unitName;
    private String detailAssetModel;
    private String detailAssetSpec;
    private String storageId;
    private String detailAssetCount;
    private String detailAssetUnit;
    private String detailAssetPrice;
    private String detailMark;
    private String detailCustomField1;
    private String detailCustomField2;
    private String detailCustomField3;
    private String detailCustomNum1;
    private String detailCustomNum2;
    private String detailCustomDate1;
    private String detailCustomDate2;
}
