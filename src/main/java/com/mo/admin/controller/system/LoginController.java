package com.mo.admin.controller.system;

import com.mo.admin.dto.Result;
import com.mo.admin.dto.system.login.LoginReqDTO;
import com.mo.admin.service.system.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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


    @GetMapping("enterprise-list")
    public Result<Object> listOptions(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map data1 = new HashMap();
        data1.put("id", "1");
        data1.put("name", "陕西金合");
        data1.put("code", "10010");
        data1.put("address", "软件新城");
        data1.put("desc", "软件开发");
        // 非营业中
        data1.put("status", true);
        Map data2 = new HashMap();
        data2.put("id", "2");
        data2.put("name", "上海金合");
        data2.put("code", "10011");
        data2.put("address", "闵行区");
        data2.put("desc", "软件集成");
        // 营业中
        data2.put("status", false);
        list.add(data1);
        list.add(data2);
        return Result.success(list);
    }

    @PostMapping("enterprise-post")
    public Result<Object> postOptions(){
        List<Map<String, String>> list = new ArrayList<>();
        Map data1 = new HashMap();
        data1.put("id", "1");
        data1.put("name", "陕西金合");
        data1.put("code", "10010");
        data1.put("address", "软件新城");
        data1.put("desc", "软件开发");
        // 非营业中
        data1.put("status", "1");
        Map data2 = new HashMap();
        data2.put("id", "2");
        data2.put("name", "上海金合");
        data2.put("code", "10011");
        data2.put("address", "闵行区");
        data2.put("desc", "软件集成");
        // 营业中
        data2.put("status", "0");
        list.add(data1);
        list.add(data2);
        return Result.success(list);
    }



    @GetMapping("enterprise-details")
    public Result<Object> listOptions(@RequestParam String id){
        List<Map<String, String>> list = new ArrayList<>();
        Map data1 = new HashMap();
        data1.put("name", "陕西金合");
        data1.put("code", "10010");
        data1.put("address", "软件新城");
        data1.put("desc", "软件开发");
//        Map data2 = new HashMap();
//        data1.put("name", "上海金合");
//        data1.put("code", "10011");
//        data1.put("address", "闵行区");
//        data1.put("desc", "软件集成");
//        list.add(data1);
//        list.add(data2);
        return Result.success(data1);
    }

    @GetMapping("/list-menu")
    public Result<Object> listMenu(){
        return Result.success(new ArrayList<>());
    }
}