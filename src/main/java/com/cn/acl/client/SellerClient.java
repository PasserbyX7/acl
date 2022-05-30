package com.cn.acl.client;

import com.cn.acl.common.Result;
import com.cn.acl.dto.SellerDTO;
import com.cn.acl.query.SellerQuery;

public interface SellerClient {

    Result<SellerDTO> getSellerDTO(SellerQuery query);
}
