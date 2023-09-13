package com.desafio.bffproducts.entrypoint.product.mapper;

import com.desafio.bffproducts.entrypoint.product.dto.StoreDto;
import com.desafio.bffproducts.service.product.domain.StoreDomain;

public interface IProductEntrypointMapper {
    StoreDto storeDomainToDto(StoreDomain storeDomain);
}
