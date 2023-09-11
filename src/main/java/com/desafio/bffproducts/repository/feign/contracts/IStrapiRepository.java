package com.desafio.bffproducts.repository.feign.contracts;


import com.desafio.bffproducts.repository.feign.entity.ProductResponse;

public interface IStrapiRepository {
    ProductResponse getProducts(String locale);
}
