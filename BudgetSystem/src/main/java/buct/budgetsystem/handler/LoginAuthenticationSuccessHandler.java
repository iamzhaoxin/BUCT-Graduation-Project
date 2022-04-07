package buct.budgetsystem.handler;

import buct.budgetsystem.pojo.domain.MyUserDetails;
import buct.budgetsystem.pojo.vo.Result;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 赵鑫
 * @Date: 2022/4/3 23:21
 */
@Component
@Slf4j
public class LoginAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("{} login",((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getUserId());
//        super.onAuthenticationSuccess(request, response, authentication);
        Result result = new Result();
        result.setCode(200);
        result.setMessage("login success");
        result.setUser(((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSONObject.toJSONString(result));
    }
}