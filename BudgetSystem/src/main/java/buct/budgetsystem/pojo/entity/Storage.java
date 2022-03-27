package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * 资产存放地点
 * 数据库表：ys_storage
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:31
 */


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Storage extends Model<Storage> {
    /**
     * 存放地点编号
     */
    @TableId
    private String storageId;
    /**
     * 存放地点名称
     */
    private String storageName;
    /**
     * 单位编号
     */
    private String unitId;
    /**
     * 单位名称
     */
    private String unitName;
}
