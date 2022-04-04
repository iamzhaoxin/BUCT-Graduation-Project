package buct.budgetsystem.handler;

import buct.budgetsystem.pojo.vo.Result;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 赵鑫
 * @Date: 2022/4/3 23:11
 */
@Component
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        Result result = new Result();
        if (exception instanceof UsernameNotFoundException) {
            // 用户不存在
            result.setCode(200);
            result.setMessage(exception.getMessage());
        } else if (exception instanceof BadCredentialsException) {
            // 密码错误
            result.setCode(200);
            result.setMessage(exception.getMessage());
        } else if (exception instanceof LockedException) {
            // 用户被锁
            result.setCode(200);
            result.setMessage(exception.getMessage());
        } else {
            // 系统错误
            result.setCode(500);
            result.setMessage(exception.getMessage());
        }
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString(result));
    }
}
