package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.Unit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/27 14:52
 */
@Mapper
public interface UnitDao extends BaseMapper<Unit> {

    @Select("select unit_principal_id from ys_unit where unit_name=#{Name}")
    String getUnitPrincipalIdByUnitName(String Name);

    @Select("select unit_principal_name from ys_unit where unit_name=#{Name}")
    String getUnitPrincipalNameByUnitName(String Name);
}
