package com.mo.admin.utils;

import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWT;
import com.mo.admin.dto.TokenInfo;

public class TokenUtils {
    public static final String TOKEN_KEY_PREFIX = "TOKEN_";
    private static final String KEY = "mo-admin-1230";

    /**
     * 生成 token
     * @param data
     * @return
     */
    public static String sign(TokenInfo data){
        return JWT.create().setPayload("data", JSONUtil.toJsonStr(data))
                .setKey(KEY.getBytes())
                .sign();
    }

    /**
     * 验证 token
     * @param token
     * @return
     */
    public static boolean verify(String token){
        return JWT.of(token).setKey(KEY.getBytes()).verify();
    }

    /**
     * 获取 token 中的信息
     * @param token
     * @return
     */
    public static TokenInfo getInfo(String token){
        JWT jwt = JWT.of(token);
        String str = (String) jwt.getPayload("data");
        return JSONUtil.parseObj(str).toBean(TokenInfo.class);
    }
}
