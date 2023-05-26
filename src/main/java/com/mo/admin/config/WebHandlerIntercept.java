package com.mo.admin.config;


import com.mo.admin.dto.TokenInfo;
import com.mo.admin.utils.RedisClient;
import com.mo.admin.utils.TokenUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class WebHandlerIntercept implements HandlerInterceptor {
    @Autowired
    private RedisClient redisClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Token");
        //
       if(StringUtils.isEmpty(token)){
           throw new SystemException("请重新登录");
       }
       // token 验证
       if(!TokenUtils.verify(token)){
           throw new SystemException("身份验证异常，请重新登录");
       }
       // 验证是否有效
       TokenInfo info = TokenUtils.getInfo(token);
       if(!redisClient.exists(info.getId())){
           throw new SystemException("token 失效，请重新登录");
       }

       return true;
    }
}
