package com.mo.admin.controller.system;

import com.mo.admin.dto.Result;
import com.mo.admin.dto.system.login.LoginReqDTO;
import com.mo.admin.service.system.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "登录",
        description = "登录相关 API"
)
@RestController
@RequestMapping("system")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(
            summary = "用户登录",
            description = "通过用户名，密码登录"
    )
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginReqDTO params){

        return loginService.login(params);
    }

    @GetMapping("current-user-info")
    public Result<Object> currentUserInfo(){
        return loginService.currentUserInfo();
    }
}