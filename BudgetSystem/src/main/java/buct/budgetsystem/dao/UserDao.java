package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/26 10:50
 */

@Mapper
public interface UserDao extends BaseMapper<User> {

}
