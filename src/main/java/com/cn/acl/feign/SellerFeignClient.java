package com.cn.acl.feign;

import com.cn.acl.dto.SellerRpcDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "sellerClient", url = "http://127.0.0.1:8080")
public interface SellerFeignClient {
    @GetMapping("/seller/{url}")
    SellerRpcDTO getSeller(@PathVariable String url);
}
