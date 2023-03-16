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
    private Integer code;
    private String msg;
    private T data;

    private static final String MSG_OK = "操作成功";

    public static Result success(){
        return Result.success(Result.MSG_OK, null);
    }

    public static Result success(String msg){
        return Result.success(msg, null);
    }

    public static Result success (String msg, Object data){
        return new Result(200, msg, data);
    }

}

