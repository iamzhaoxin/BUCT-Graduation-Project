package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

import java.util.List;
import java.util.Set;

/**
 * 角色（单用户-单角色-多菜单权限）
 * 数据库表：ys_role
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:31
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role extends Model<Role> {

    /**
     * 角色id
     */
    @TableId
    private Integer roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDescription;

}
