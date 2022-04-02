package buct.budgetsystem.service;

import buct.budgetsystem.dao.UserDao;
import buct.budgetsystem.pojo.entity.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/26 10:51
 */

@Service
public class UserService extends ServiceImpl<UserDao, User> {
}
