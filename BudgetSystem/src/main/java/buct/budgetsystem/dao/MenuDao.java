package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/27 8:23
 */
@Mapper
public interface MenuDao extends BaseMapper<Menu> {
}
