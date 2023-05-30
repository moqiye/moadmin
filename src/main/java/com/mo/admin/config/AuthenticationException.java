package com.mo.admin.config;


import com.mo.admin.dto.Result;

public class AuthenticationException extends Exception{

    private String code;

    public AuthenticationException(String code, String message){
        super(message);
        this.code = code;
    }

    public AuthenticationException(String message){
        super(message);
        this.code = Result.CODE_UNAUTHORIZED;
    }

    public String getCode(){
        return this.code;
    }
}
