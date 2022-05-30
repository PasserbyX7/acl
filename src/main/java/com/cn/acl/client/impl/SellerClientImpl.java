package com.cn.acl.client.impl;

import javax.annotation.Resource;

import com.cn.acl.annotation.RpcMonitoring;
import com.cn.acl.client.SellerClient;
import com.cn.acl.common.Result;
import com.cn.acl.dto.SellerDTO;
import com.cn.acl.exception.ErrorCode;
import com.cn.acl.feign.SellerFeignClient;
import com.cn.acl.query.SellerQuery;

import org.springframework.stereotype.Service;

@Service
public class SellerClientImpl implements SellerClient {

    @Resource
    private SellerFeignClient client;

    /**
     * 监控上报：打印调用日志、调用时长等
     * 异常处理：建议统一返回Result，在接口层做切面捕获所有异常
     */
    @RpcMonitoring
    @Override
    public Result<SellerDTO> getSellerDTO(SellerQuery query) {
        try {
            return Result.success(client.getSeller(query.getUrl()).getData());
        } catch (Exception e) {
            return Result.fail(ErrorCode.RPC_GET_SELLER_ERROR);
        }
    }

}