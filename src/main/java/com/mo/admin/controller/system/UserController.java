package com.mo.admin.controller.system;

import com.mo.admin.dto.Result;
import com.mo.admin.entity.User;
import com.mo.admin.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("save")
    public Result<User> saveUser(@RequestBody User user){
        return Result.success("操作成功",userService.saveUser(user));
    }

    @GetMapping("list")
    public Result<List<User>> listUser() {
        return Result.success("操作成功",userService.listUsers());
    }

    @GetMapping("search")
    public Result<List<User>> listByName(@RequestParam String username) {
        return Result.success("操作成功",userService.searchUser(username));
    }

}
