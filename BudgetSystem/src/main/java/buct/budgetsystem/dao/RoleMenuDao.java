package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/27 8:54
 */
@Mapper
public interface RoleMenuDao extends BaseMapper<RoleMenu> {

    @Select("select menu_id from ys_role_menu where role_id=#{roleId}")
    List<Integer> getMenusByRoleId(int roleId);

    @Select("select role_id from ys_role_menu where menu_id=#{menuId}")
    List<Integer> getRolesByMenuId(int menuId);

}
