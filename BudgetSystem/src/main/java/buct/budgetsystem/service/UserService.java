package buct.budgetsystem.service;

import buct.budgetsystem.dao.UserDao;
import buct.budgetsystem.pojo.entity.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/26 10:51
 */

@Service
public class UserService extends ServiceImpl<UserDao, User> {

    private final UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 分页查询
     */
    public Page<User> getPage(int pageNumber, int pageSize){
        Page<User> page=new Page<>(pageNumber,pageSize);
        userDao.selectPage(page, null);
        return page;
    }

}
