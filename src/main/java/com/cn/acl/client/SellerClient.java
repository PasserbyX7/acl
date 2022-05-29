package com.cn.acl.client;

import com.cn.acl.common.Result;
import com.cn.acl.dto.SellerDTO;

public interface SellerClient {
    Result<SellerDTO> getSellerDTO(String url);
}
