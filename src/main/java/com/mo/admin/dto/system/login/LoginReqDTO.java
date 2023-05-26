package com.mo.admin.dto.system.login;

import lombok.Data;

/**
 * 登录参数
 */
@Data
public class LoginReqDTO {
    private String username;
    private String password;
}
