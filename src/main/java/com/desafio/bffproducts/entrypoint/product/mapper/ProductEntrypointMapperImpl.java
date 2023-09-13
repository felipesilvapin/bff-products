package com.desafio.bffproducts.entrypoint.product.mapper;

import com.desafio.bffproducts.entrypoint.product.dto.ProductDto;
import com.desafio.bffproducts.entrypoint.product.dto.StoreDto;
import com.desafio.bffproducts.service.product.domain.ProductDomain;
import com.desafio.bffproducts.service.product.domain.StoreDomain;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProductEntrypointMapperImpl implements IProductEntrypointMapper {

    @Override
    public StoreDto storeDomainToDto(StoreDomain storeDomain) {
        if (storeDomain == null) {
            return null;
        }

        StoreDto storeDto = new StoreDto();
        storeDto.setProduct(storeDomain.getProduct().stream()
                .map(this::mapProductDomainToDto)
                .collect(Collectors.toList()));

        return storeDto;
    }

    private ProductDto mapProductDomainToDto(ProductDomain productDomain) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(productDomain.getProductId());
        productDto.setValue(productDomain.getValue());
        return productDto;
    }
}