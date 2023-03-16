package com.mo.admin.server.controller.system;

import com.mo.admin.server.dto.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("system")
public class LoginController {
    @GetMapping("login")
    public Result<String> login(){
        return Result.success();
    }

}