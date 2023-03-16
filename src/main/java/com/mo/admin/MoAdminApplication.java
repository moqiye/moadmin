package com.mo.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.mo.admin.mapper")
public class MoAdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(MoAdminApplication.class, args);
	}

}
