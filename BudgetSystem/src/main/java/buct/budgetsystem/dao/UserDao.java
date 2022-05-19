package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/26 10:50
 */
@Mapper
public interface UserDao extends BaseMapper<User> {


    @Select("select user_cellphone from ys_user where user_id=#{Id}")
    String getUserPhoneById(String Id);

    @Select("select user_name from ys_user where user_id=#{Id}")
    String getUserNameById(String Id);
}
