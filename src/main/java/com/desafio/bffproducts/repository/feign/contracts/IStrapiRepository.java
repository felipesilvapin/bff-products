package com.desafio.bffproducts.repository.feign.contracts;


import com.desafio.bffproducts.repository.feign.entity.ProductResponseEntity;

public interface IStrapiRepository {
    ProductResponseEntity getProducts(String locale);
}
