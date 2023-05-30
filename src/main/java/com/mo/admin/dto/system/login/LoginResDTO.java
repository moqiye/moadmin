package com.mo.admin.dto.system.login;

import lombok.Builder;
import lombok.Data;

/**
 * 登录响应对象
 */
@Data
@Builder
public class LoginResDTO {
    private String token;
}
