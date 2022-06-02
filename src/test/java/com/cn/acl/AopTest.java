package com.cn.acl;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import javax.annotation.Resource;

import com.cn.acl.client.SellerFeignClient;
import com.cn.acl.dto.SellerRpcDTO;
import com.cn.acl.facade.SellerFacade;
import com.cn.acl.query.SellerQuery;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AopTest {

    @Resource
    private SellerFacade sellerClient;

    @MockBean
    private SellerFeignClient client;

    @Test
    void test403() {
        doReturn(new SellerRpcDTO(403, null)).when(client).getSeller(anyString());
        SellerQuery query = new SellerQuery("test");
        sellerClient.getSellerDTO(query);
    }

    @Test
    void testException() {
        doThrow(new IllegalArgumentException()).when(client).getSeller(anyString());
        SellerQuery query = new SellerQuery("test");
        sellerClient.getSellerDTO(query);
    }

}