package com.desafio.bffproducts.repository.feign.implementation;

import com.desafio.bffproducts.repository.feign.client.IStrapiFeignClient;
import com.desafio.bffproducts.repository.feign.contracts.IStrapiRepository;
import com.desafio.bffproducts.repository.feign.entity.ProductResponseEntity;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
@RequiredArgsConstructor
public class StrapiRepositoryImpl implements IStrapiRepository {

    private final IStrapiFeignClient strapiFeignClient;
    @Value("${feign.client.config.strapi.api.authorization}")
    String strapiAuthorization;

    @Override
    public ProductResponseEntity getProducts(final String locale) {
        ProductResponseEntity response = null;
        try {
            response = strapiFeignClient.getProducts(strapiAuthorization, "*", locale);
        }
        catch (FeignException e) {
            System.err.println("Não há produtos cadastrados no Strapi.");
        }
        return response;
    }

    @Override
    public ProductResponseEntity getProductById(String productId, String locale) {
        ProductResponseEntity response = null;
        try {
            response = strapiFeignClient.getProductById(strapiAuthorization, productId, "*", locale);
        }
        catch (FeignException e) {
            System.err.println("Não há produto com id ${productId} cadastrado");
        }
        return response;
    }
}
