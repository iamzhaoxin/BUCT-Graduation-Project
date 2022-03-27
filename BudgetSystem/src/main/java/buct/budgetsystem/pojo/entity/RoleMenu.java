package buct.budgetsystem.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;

/**
 * 角色权限（多角色-多导航权限）
 * ys_role_menu
 * @Author: 赵鑫
 * @Date: 2022/3/16 14:31
 */


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoleMenu extends Model<RoleMenu>{

    /**
     * 主键id
     */
    @TableId
    private Integer roleMenuId;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 导航id
     */
    private Integer menuId;

}
