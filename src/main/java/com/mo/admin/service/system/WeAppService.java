package com.mo.admin.service.system;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.mo.admin.config.RedisConfig;
import com.mo.admin.config.WeAppConfig;
import com.mo.admin.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeAppService {

    public static final String WE_APP_ACCESS_TOKEN_KEY = "we_app_access_token";

    @Autowired
    WeAppConfig weAppConfig;

    @Autowired
    RedisClient redisClient;

    public String getAccessToken() throws IOException, InterruptedException {
        String cacheToken = (String)redisClient.get(WE_APP_ACCESS_TOKEN_KEY);
        if(cacheToken != null){
            return cacheToken;
        }
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("https://api.weixin.qq.com/cgi-bin/token"
                + "?grant_type=client_credential"
                + "&appid=" + weAppConfig.getAppid()
                + "&secret="+weAppConfig.getSecret());

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());  	//同步发送
        System.out.println(response.statusCode()); 	//打印响应状态码
        System.out.println(response.body());
        JSONObject jo = JSONUtil.parseObj(response.body());
        String token = jo.getStr("access_token");
        redisClient.set(WE_APP_ACCESS_TOKEN_KEY,token);
        redisClient.expire(WE_APP_ACCESS_TOKEN_KEY, jo.getLong("expires_in") - 10);
        return token;
    }

    public Object getPhoneNumber(String code) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String accessToken = getAccessToken();


        URI uri = URI.create("https://api.weixin.qq.com/wxa/business/getuserphonenumber"
                + "?access_token="
                + accessToken + "&code="+code);
        Map param = new HashMap<String,String>();
        param.put("code", code);
        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(JSONUtil.toJsonStr(param)))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());  	//同步发送
        System.out.println(response.statusCode()); 	//打印响应状态码
        System.out.println(response.body());
        JSONObject jo = JSONUtil.parseObj(response.body());
        JSONObject token = jo.getJSONObject("phone_info");
        return token;
    }
}
