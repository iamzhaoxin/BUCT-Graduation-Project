package buct.budgetsystem.config;

import buct.budgetsystem.handler.LoginAuthenticationFailureHandler;
import buct.budgetsystem.handler.LoginAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @Author: 赵鑫
 * @Date: 2022/3/30 20:21
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final LoginAuthenticationSuccessHandler loginSuccessHandler;
    private final LoginAuthenticationFailureHandler loginFailureHandler;


    public SecurityConfig(LoginAuthenticationSuccessHandler loginSuccessHandler, LoginAuthenticationFailureHandler loginFailureHandler) {
        this.loginSuccessHandler = loginSuccessHandler;
        this.loginFailureHandler = loginFailureHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()   //禁用跨站csrf攻击防御
                .formLogin()
                .loginProcessingUrl("/login")
                //登录表单form中用户名输入框input的name名，不修改的话默认是username
                .usernameParameter("username")
                //form中密码输入框input的name名，不修改的话默认是password
                .passwordParameter("password")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)
                .and()
                //权限校验规则
                .authorizeRequests()
                //不需要通过登录验证就可以被访问的资源路径
                .antMatchers("/login.html", "/login", "/config/**", "/css/**", "/fonts/**", "/img/**", "/js/**")
                .permitAll()
                .anyRequest().permitAll()
                .and()
                //Session管理
                .sessionManagement()
                // 需要时创建Session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                // Session超时 跳转登陆页面
                .invalidSessionUrl("/login");

    }

/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()   //禁用跨站csrf攻击防御
                .formLogin()
                //用户未登录时，访问任何资源都转跳到该路径，即登录页面; 这个页面必须要放在resources/resources里，否则提交不会生效，估计是安全框架的机制
                //如果注释掉，则使用默认的登录页
//                .loginPage("/login.html")
                //这里的名字和登录表单form中action的地址一致，就可以调框架自带的登录
                .loginProcessingUrl("/login")
                //登录表单form中用户名输入框input的name名，不修改的话默认是username
                .usernameParameter("username")
                //form中密码输入框input的name名，不修改的话默认是password
                .passwordParameter("password")
//                .defaultSuccessUrl("/index")
//                .successForwardUrl("success.html")
//                .failureForwardUrl("failure.html")
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)

                .and()
                //权限校验规则
                .authorizeRequests()
                //不需要通过登录验证就可以被访问的资源路径
                .antMatchers("/login.html", "/login", "/config/**", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
                .anyRequest().permitAll()

                .and()
                //Session管理
                .sessionManagement()
                // 需要时创建Session
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                // Session超时 跳转登陆页面
                .invalidSessionUrl("/login");

    }*/

    /**
     * 密码加密器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
