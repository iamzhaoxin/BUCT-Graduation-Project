package buct.budgetsystem.security;

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
import java.util.List;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/26 10:53
 */

@Slf4j
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getOneUserById(username);   //Fixme 会不会因为重名导致bug？
        if(user == null){
            return null;
        }
        log.info("user=={}",user);
        List<GrantedAuthority> authority = new ArrayList<>();
        authority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getUserPassword(),
                authority
        );
    }
}
