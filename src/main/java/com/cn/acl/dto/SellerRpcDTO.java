package com.cn.acl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SellerRpcDTO {
    private Integer code;
    private SellerDTO data;
}
