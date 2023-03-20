package com.mo.admin.controller.system;

import com.mo.admin.dto.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "登录",
        description = "登录相关 API"
)
@RestController
@RequestMapping("system")
public class LoginController {

    @Operation(
            summary = "用户登录",
            description = "通过用户名，密码登录"
    )
    @GetMapping("login")
    public Result<String> login(){
        return Result.success();
    }
}
