package com.mo.admin.controller.system;

import com.mo.admin.dto.Result;
import com.mo.admin.service.system.WeAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("weapp")
public class WeAppController {

    @Autowired
    private WeAppService weAppService;

    @GetMapping("phone-number")
    public Result<Object> userInfo(@RequestParam String code) throws IOException, InterruptedException {
        Object phoneNumber = weAppService.getPhoneNumber(code);
        return Result.success(phoneNumber);
    }
}
