package com.cn.acl;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

import javax.annotation.Resource;

import com.cn.acl.client.SellerClient;
import com.cn.acl.dto.SellerRpcDTO;
import com.cn.acl.feign.SellerFeignClient;
import com.cn.acl.query.SellerQuery;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AopTest {

    @Resource
    private SellerClient sellerClient;

    @MockBean
    private SellerFeignClient client;

    @Test
    void test403() {
        doReturn(new SellerRpcDTO(403, null)).when(client).getSeller(anyString());
        SellerQuery query = new SellerQuery("test");
        sellerClient.getSellerDTO(query);
    }

}