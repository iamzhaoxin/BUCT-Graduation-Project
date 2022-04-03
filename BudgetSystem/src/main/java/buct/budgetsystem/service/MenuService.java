package buct.budgetsystem.service;

import buct.budgetsystem.dao.MenuDao;
import buct.budgetsystem.pojo.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author: 赵鑫
 * @Date: 2022/4/1 23:35
 */
@Service
public class MenuService extends ServiceImpl<MenuDao, Menu> {
}
