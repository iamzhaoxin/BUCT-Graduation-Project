package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/27 8:01
 */
@Mapper
public interface RoleDao extends BaseMapper<Role> {

}
