package com.desafio.bffproducts.entrypoint.product.mapper;

import com.desafio.bffproducts.entrypoint.product.dto.ProductDto;
import com.desafio.bffproducts.entrypoint.product.dto.StoreDto;
import com.desafio.bffproducts.service.product.domain.ProductDomain;
import com.desafio.bffproducts.service.product.domain.StoreDomain;

public interface IProductEntrypointMapper {
    StoreDto storeDomainToDto(StoreDomain storeDomain);

    ProductDto productDomainToDto(ProductDomain productDomain);
}
