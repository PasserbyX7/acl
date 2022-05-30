package com.cn.acl.facade.impl;

import javax.annotation.Resource;

import com.cn.acl.client.SellerClient;
import com.cn.acl.dto.SellerDTO;
import com.cn.acl.facade.SellerFacade;
import com.cn.acl.query.SellerQuery;

import org.springframework.stereotype.Service;

@Service
public class SellerFacadeImpl implements SellerFacade {

    @Resource
    private SellerClient sellerClient;

    @Override
    public SellerDTO getSellerDTO(SellerQuery query) {
        return sellerClient.getSellerDTO(query).getData();
    }

}
