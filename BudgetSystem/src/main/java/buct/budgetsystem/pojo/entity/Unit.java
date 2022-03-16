package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @About: 数据库表：ys_user
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:31
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Unit extends Model<Unit> {
    private String unitId;
    private String unitName;
    private String unitSuperId;
    private String unitNature;
    private String unitMark;
    private String unitPrincipalId;
    private String unitPrincipalName;
}
