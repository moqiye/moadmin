package com.mo.admin.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisClient {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 指定缓存失效时间
     * @param key key 键
     * @param time 时间（秒）
     * @return
     */
    public boolean expire(String key, long time){
        try{
            if(time > 0){
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据 key 获取过期时间
     * @param key 键 不能为 null
     * @return 时间（秒） 返回 0 代表永久有效
     *
     */
    public long ttl(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断 key 是否存在
     * @param key 键
     * @return true 存在 false 不存在
     */
    public Boolean exists(String key){
        return redisTemplate.hasKey(key);
    }

    //============== String ====================
    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return true 成功 false 失败
     */
    public boolean set(String key, Object value){
        try{
            redisTemplate.opsForValue().set(key, value);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存获取
     * @param key 键
     * @return 值
     */
    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除缓存
     * @param key
     * @return
     */
    public Boolean del(String key){
        return redisTemplate.delete(key);
    }

    /**
     * HashGet
     * @param key 键 不能为 null
     * @param item 项 不能为 null
     * @return 值
     */
    public Object hget(String key, String item){
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * HashGet
     * @param key 键 不能为 null
     * @param item item 项 不能为 null
     * @param value 值
     * @return true 成功 false 失败
     */
    public boolean hset(String key, String item, Object value){
        try{
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除 hash 表中的值
     * @param key 键 不能为 null
     * @param item 项 可以是多个 不能为 null
     */
    public void hdel(String key, Object... item){
        redisTemplate.opsForHash().delete(key,item);
    }
}

