package com.mo.admin.config;

import com.mo.admin.dto.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Object defaultErrorHandler(HttpServletRequest req, Exception e){
        // 自定义登录异常
        if(e instanceof AuthenticationException){
            return Result.builder().code(Result.CODE_UNAUTHORIZED).msg(Result.MSG_UNAUTHORIZED).build();
        }
        return Result.error();
    }
}
