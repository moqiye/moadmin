package com.mo.admin.service.system;

import cn.hutool.core.bean.BeanUtil;
import com.mo.admin.dto.Result;
import com.mo.admin.dto.TokenInfo;
import com.mo.admin.dto.system.login.LoginReqDTO;
import com.mo.admin.entity.User;
import com.mo.admin.repository.UserRepository;
import com.mo.admin.utils.RedisClient;
import com.mo.admin.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    RedisClient redisClient;
    @Autowired
    private UserRepository userRepository;

    // 默认过期时间，6 小时
    private static final long EXPIRE_SECOND = 1000 * 60 * 60 * 6;

    /**
     * 登录
     * @param params
     * @return
     */
    public Result<String> login(LoginReqDTO params) {
        User user = userRepository.findByUsername(params.getUsername());
        if(null == user){
            return Result.error("用户名或密码错误");
        }

        String password = user.getPassword();
        if(!params.getPassword().equals(password)){
            return Result.error("用户名或密码错误");
        }

        TokenInfo info = BeanUtil.toBean(user, TokenInfo.class);
        String token = TokenUtils.sign(info);
        String key = TokenUtils.TOKEN_KEY_PREFIX + user.getId();
        redisClient.set(key, token, EXPIRE_SECOND);
        return Result.success(token);
    }

    /**
     * 获取当前登录信息
     * @return
     */
    public Result<Object> currentUserInfo() {
        return Result.success();
    }
}
