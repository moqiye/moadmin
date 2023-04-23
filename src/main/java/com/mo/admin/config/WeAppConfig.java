package com.mo.admin.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
public class WeAppConfig {

    @Value(value = "${we-app.appid}")
    private String appid;
    @Value(value = "${we-app.secret}")
    private String secret;
}
