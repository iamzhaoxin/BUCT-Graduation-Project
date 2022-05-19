package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.DeclarationDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/27 15:30
 */
@Mapper
public interface DeclarationDetailDao extends BaseMapper<DeclarationDetail>{

    @Select("select detail_asset_id from ys_declaration_detail where declaration_id=#{declarationId}")
    Integer getAssetIdByDeclarationId(Integer declarationId);

    @Select("select * from ys_declaration_detail where declaration_id=#{declarationId}")
    DeclarationDetail getDetailByDeclarationId(Integer declarationId);
}
