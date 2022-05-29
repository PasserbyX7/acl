package com.cn.acl.common;

import com.cn.acl.exception.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<T>(0, "success", data);
    }

    public static <T> Result<T> fail(ErrorCode code) {
        return new Result<T>(code.getCode(), code.getMsg(), null);
    }

}
