package com.mo.admin.dto.system.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录参数
 */
@Data
public class LoginReqDTO {
    private String username;
    private String password;
}
