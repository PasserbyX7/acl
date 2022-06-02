package com.cn.acl.facade.impl;

import javax.annotation.Resource;

import com.cn.acl.annotation.RpcMonitoring;
import com.cn.acl.annotation.RpcResultHandler;
import com.cn.acl.assembler.SellerAssembler;
import com.cn.acl.client.SellerFeignClient;
import com.cn.acl.common.Result;
import com.cn.acl.constant.RpcEnum;
import com.cn.acl.dto.Seller;
import com.cn.acl.dto.SellerRpcDTO;
import com.cn.acl.exception.BizException;
import com.cn.acl.exception.ErrorCode;
import com.cn.acl.facade.SellerFacade;
import com.cn.acl.query.SellerQuery;

import org.springframework.stereotype.Service;

@Service
public class SellerFacadeImpl implements SellerFacade {

    private SellerAssembler assembler = SellerAssembler.INSTANCE;

    @Resource
    private SellerFeignClient client;

    /**
     * 监控上报：打印调用日志、调用时长等
     * 异常处理：建议统一返回Result，在接口层做切面捕获所有异常
     * TODO 重试机制：重试注解加在Feign上，无法解决根据返回内容判断是否重试；加在FacadeImpl上，会被aop吞掉
     * TODO 临时不可用和永久不可用
     */

    @RpcMonitoring(RpcEnum.SELLER)
    @RpcResultHandler(ErrorCode.RPC_GET_SELLER_ERROR)
    @Override
    public Result<Seller> getSellerDTO(SellerQuery query) {
        SellerRpcDTO sellerRpcDTO = client.getSeller(query.getUrl());
        if (sellerRpcDTO.getCode() != 0) {
            throw new BizException("get seller error");
        }
        return Result.success(assembler.toEntity(sellerRpcDTO.getData()));
    }

}