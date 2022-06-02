package com.cn.acl.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cn.acl.dto.SellerRpcDTO;

@Retryable(maxAttempts = 3, backoff = @Backoff(delay = 100))
@FeignClient(name = "sellerClient", url = "http://127.0.0.1:8080")
public interface SellerFeignClient {
    @GetMapping("/seller/{url}")
    SellerRpcDTO getSeller(@PathVariable String url);
}