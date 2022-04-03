package buct.budgetsystem.pojo.domain;

import buct.budgetsystem.pojo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.security.auth.Subject;
import java.util.Collection;
import java.util.Set;

/**
 * 废弃
 * @Author: 赵鑫
 * @Date: 2022/3/26 16:56
 * @About: 重写用于Spring Security验证的UserDetails
 */
public class MyUserDetails implements UserDetails {
    /**
     * 用户信息
     */
    private final User user;
    /**
     * 用户角色（String）
     */
    private final Set<SimpleGrantedAuthority> authorities;
    /**
     * 用户权限（menu）
     */
    private final Set<String> permissions;

    public MyUserDetails(User user, Set<SimpleGrantedAuthority> authorities, Set<String> permissions) {
        this.user = user;
        this.authorities = authorities;
        this.permissions = permissions;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getUserPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
