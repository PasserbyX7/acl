package com.cn.acl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.cn.acl.client.SellerClient;
import com.cn.acl.common.Result;
import com.cn.acl.dto.SellerDTO;
import com.cn.acl.dto.SellerRpcDTO;
import com.cn.acl.query.SellerQuery;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Resource
    private SellerClient sellerClient;

    @GetMapping("/403")
    public SellerRpcDTO getSeller1(HttpServletResponse response) {
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return new SellerRpcDTO(403, null);
    }

    @GetMapping("/error")
    public SellerRpcDTO getSeller2(HttpServletResponse response) {
        return new SellerRpcDTO(1, null);
    }

    @GetMapping("/success")
    public SellerRpcDTO getSeller3(HttpServletResponse response) {
        return new SellerRpcDTO(0, new SellerDTO("seller"));
    }

    /**
     * http://localhost:8080/seller/client/{url}
     */
    @GetMapping("/client/{url}")
    public Result<SellerDTO> getFeignSeller(@PathVariable String url) {
        SellerQuery query = new SellerQuery(url);
        return sellerClient.getSellerDTO(query);
    }

}
