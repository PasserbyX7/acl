package com.cn.acl.assembler;

import com.cn.acl.dto.Seller;
import com.cn.acl.dto.SellerRpcDTO.MySellerDTO;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SellerAssembler {
    SellerAssembler INSTANCE = Mappers.getMapper(SellerAssembler.class);
    Seller toEntity(MySellerDTO sellerDTO);
}
