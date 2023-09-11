package com.desafio.bffproducts.repository.feign.implementation;

import com.desafio.bffproducts.repository.feign.client.IStrapiFeignClient;
import com.desafio.bffproducts.repository.feign.contracts.IStrapiRepository;
import com.desafio.bffproducts.repository.feign.entity.ProductResponse;
import feign.FeignException;
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
    public ProductResponse getProducts(final String locale) {
        ProductResponse response = null;
        try {
            response = strapiFeignClient.getProducts(strapiAuthorization, "*", locale);
        }
        catch (FeignException e) {
            System.err.println("Não há produtos cadastrados no Strapi.");
        }
        return response;
    }
}
