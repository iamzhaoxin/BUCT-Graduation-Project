package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.Declaration;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/27 15:29
 */
@Mapper
public interface DeclarationDao extends BaseMapper<Declaration> {

    @Select("select declaration_id from ys_declaration where user_id_apply=#{userId}")
    Integer[] getIdsByUserId(Integer userId);

    @Select("select * from ys_declaration where user_id_apply=#{userId}")
    Declaration[] getDeclarationsByUserId(Integer userId);
}
