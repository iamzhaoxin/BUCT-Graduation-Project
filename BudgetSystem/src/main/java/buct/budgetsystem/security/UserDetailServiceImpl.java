package buct.budgetsystem.security;

import buct.budgetsystem.pojo.domain.MyUserDetails;
import buct.budgetsystem.pojo.entity.Role;
import buct.budgetsystem.pojo.entity.User;
import buct.budgetsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user=new User();
        user.setUserId(userId);
        user=user.selectById();

        if(user == null){
            return null;
        }

        log.info("user=={}",user);
        //加载用户权限
//        Set<Role> userRoles=user.getRoleId();
        Set<SimpleGrantedAuthority> authority = new HashSet<>();
        return new MyUserDetails(
                user.getUserName(),
                user.getUserPassword(),
                authority
        );
    }
}
