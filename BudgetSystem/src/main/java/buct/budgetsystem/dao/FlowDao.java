package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.Flow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.File;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/27 15:31
 */
@Mapper
public interface FlowDao extends BaseMapper<Flow> {
    @Select("select BYTES_ from ACT_GE_BYTEARRAY where NAME_=#{processId}")
    File getBpmnByName(String processId);

    @Select("select BYTES_ from ACT_GE_BYTEARRAY where NAME_=#{diagramResourceName}")
    File getPngByName(String diagramResourceName);

    @Select("delete from ys_flow where declaration_id=#{declarationId}")
    void removeByDeclarationId(Integer declarationId);

    @Select("select flow_state from ys_flow where declaration_id=#{declarationId}")
    String getStatusByDeclarationId(String declarationId);

    @Select("update ys_flow set flow_state=\"驳回\", flow_opinion=#{suggestion},user_id=#{userId},user_name=#{userName} where declaration_id=#{declarationId}")
    void refuseDeclarationById(String declarationId,String suggestion,Integer userId,String userName);

    @Select("update ys_flow set flow_state=\"审批中\", flow_opinion=#{suggestion},user_id=#{userId},user_name=#{userName} where declaration_id=#{declarationId}")
    void agreeDeclarationById(String declarationId, String suggestion, Integer userId, String userName);

    @Select("select * from ACT_RU_TASK where ID_=#{id}")
    Object findActRuTaskByID(String id);

    @Select("update ys_flow set flow_state=\"审批通过\", flow_opinion=#{suggestion},user_id=#{userId},user_name=#{userName} where declaration_id=#{declarationId}")
    void finishDeclarationById(String declarationId, String suggestion, Integer userId, String userName);
}
