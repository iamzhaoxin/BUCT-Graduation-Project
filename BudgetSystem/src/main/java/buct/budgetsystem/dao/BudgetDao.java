package buct.budgetsystem.dao;

import buct.budgetsystem.pojo.entity.Budget;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/27 15:28
 */
@Mapper
public interface BudgetDao extends BaseMapper<Budget> {

}
