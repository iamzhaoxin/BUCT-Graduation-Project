package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * 部门
 * 数据库表：ys_unit
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:31
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Unit extends Model<Unit> {
    /**
     * 单位编号
     */
    @TableId
    private String unitId;
    /**
     * 单位名称
     */
    private String unitName;
    /**
     * 上一级单位编号
     */
    private String unitSuperId;
    /**
     * 单位性质 教学（1）科研（2）教辅（3）行政（4）后勤（5）其他（6）
     */
    private String unitNature;
    /**
     * “*”表示最低一级单位
     */
    private String unitMark;
    /**
     * 部门负责人工号
     */
    private String unitPrincipalId;
    /**
     * 部门负责人姓名
     */
    private String unitPrincipalName;
}
