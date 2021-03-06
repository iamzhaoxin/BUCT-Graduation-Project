package buct.budgetsystem.security;

import buct.budgetsystem.pojo.domain.MyUserDetails;
import buct.budgetsystem.pojo.entity.User;
import buct.budgetsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/26 10:53
 */

@Slf4j
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    final UserService userService;
    public UserDetailServiceImpl(UserService userService) {
        this.userService = userService;
    }

    /**
     * UserDetailsService's method loadByUsername is just a method which allows you to retrieve the user from
     * your database and compare it with the credentials from the request from the client to see if it is an
     * existing user or non_existing one. Although the name of the method is loadUserByUsername, it doesn't
     * mean that you must literally pass a username, you can pass it any argument like email, phone number or
     * whatever your authentication is based on.
     */
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        log.info("登录验证");
        User user=new User();
        user.setUserId(userId);
        user=user.selectById();

        if(user == null){
            log.info("登录用户：{} 不存在.", userId);
            throw new UsernameNotFoundException("登录用户：" + userId + " 不存在");
        }

        log.info("user.id=={}",user.getUserId());

        return new MyUserDetails(user);
    }
}
