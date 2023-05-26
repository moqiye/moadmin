package com.mo.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    public static final Integer CODE_SUCCESS = 200;
    private static final String MSG_OK = "操作成功";
    public static final Integer CODE_ERROR = 500;
    public static final String MSG_ERROR = "服务异常";

    private Integer code;
    private String msg;
    private T data;



    public static Result success(){
        return Result.success(Result.MSG_OK, null);
    }

    public static Result success(Object data){
        return Result.success(Result.MSG_OK, data);
    }

    public static Result success (String msg, Object data){
        return new Result(CODE_SUCCESS, msg, data);
    }

    public static Result error(String msg){
        return new Result(CODE_ERROR, msg, null);
    }

    public static Result error(){
        return error(MSG_ERROR);
    }

}

