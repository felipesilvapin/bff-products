package com.desafio.bffproducts.service.product.mapper;

import com.desafio.bffproducts.repository.feign.entity.ProductEntity;
import com.desafio.bffproducts.repository.feign.entity.ProductResponseEntity;
import com.desafio.bffproducts.service.product.domain.ProductDomain;
import com.desafio.bffproducts.service.product.domain.StoreDomain;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IProductServiceMapper {
    default StoreDomain productEntityToDomain(final ProductResponseEntity productResponse) {
        final List<ProductDomain> productsList = new ArrayList<>();
        final StoreDomain storeDomain = new StoreDomain();

        if (productResponse != null) {
            for (final ProductEntity productEntity : productResponse.getData().getAttributes().getProducts()) {
                ProductDomain productDomain = convertProductEntityToDomain(productEntity);
                productsList.add(productDomain);
            }
        }

        storeDomain.setProduct(productsList);

        return storeDomain;
    }

    private ProductDomain convertProductEntityToDomain(ProductEntity productEntity) {
        ProductDomain productDomain = new ProductDomain();

        productDomain.setProductId(productEntity.getId());
        productDomain.setValue(productEntity.getValue());

        return productDomain;
    }
}
