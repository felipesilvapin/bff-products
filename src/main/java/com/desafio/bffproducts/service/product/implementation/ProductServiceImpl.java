package com.desafio.bffproducts.service.product.implementation;

import com.desafio.bffproducts.repository.feign.contracts.IStrapiRepository;
import com.desafio.bffproducts.repository.feign.entity.ProductAttributesEntity;
import com.desafio.bffproducts.repository.feign.entity.ProductDataEntity;
import com.desafio.bffproducts.repository.feign.entity.ProductResponseEntity;
import com.desafio.bffproducts.service.product.contracts.IProductService;
import com.desafio.bffproducts.service.product.domain.StoreDomain;
import com.desafio.bffproducts.service.product.mapper.IProductServiceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements IProductService {
    private final IStrapiRepository strapiRepository;
    private final IProductServiceMapper productServiceMapper;

    @Override
    public ResponseEntity<StoreDomain> getProducts(final String locale) {
      final ProductResponseEntity productResponseEntity = strapiRepository.getProducts(locale);
        ResponseEntity<StoreDomain> response = null;

        final boolean hasProducts = Optional.ofNullable(productResponseEntity)
                .map(ProductResponseEntity::getData)
                .map(ProductDataEntity::getAttributes)
                .map(ProductAttributesEntity::getProducts)
                .map(List::size)
                .filter(size -> size > 0)
                .isPresent();

        if (hasProducts) {
           final StoreDomain domain = productServiceMapper.productEntityToDomain(productResponseEntity);
           final StoreDomain storeDomain = new StoreDomain();

            storeDomain.setProduct(domain.getProduct());

            response = ResponseEntity.ok(storeDomain);
        }

        return response;
    }
}
