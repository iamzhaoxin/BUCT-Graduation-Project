package buct.budgetsystem.service;

import buct.budgetsystem.dao.BudgetDao;
import buct.budgetsystem.pojo.entity.Budget;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BudgetService extends ServiceImpl<BudgetDao, Budget> {

}
