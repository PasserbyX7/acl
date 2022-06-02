package com.cn.acl.facade;

import com.cn.acl.common.Result;
import com.cn.acl.dto.Seller;
import com.cn.acl.query.SellerQuery;

public interface SellerFacade {

    Result<Seller> getSellerDTO(SellerQuery query);
}
