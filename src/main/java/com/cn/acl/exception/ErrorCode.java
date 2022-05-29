package com.cn.acl.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    RPC_GET_SELLER_ERROR(000001, "rpc get seller error");

    private Integer code;
    private String msg;
}
