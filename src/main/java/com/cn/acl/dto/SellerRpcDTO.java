package com.cn.acl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class SellerRpcDTO {
    private Integer code;
    private MySellerDTO data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MySellerDTO {
        private String name;
    }
}
