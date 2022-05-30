package com.cn.acl.facade;

import com.cn.acl.dto.SellerDTO;
import com.cn.acl.query.SellerQuery;

public interface SellerFacade {
    SellerDTO getSellerDTO(SellerQuery query);
}
