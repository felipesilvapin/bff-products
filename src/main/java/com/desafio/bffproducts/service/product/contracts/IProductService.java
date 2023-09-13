package com.desafio.bffproducts.service.product.contracts;

import com.desafio.bffproducts.service.product.domain.ProductDomain;
import com.desafio.bffproducts.service.product.domain.StoreDomain;
import org.springframework.http.ResponseEntity;

public interface IProductService {
    ResponseEntity<StoreDomain> getProducts(String locale);

    ResponseEntity<ProductDomain> getProductById(final String productId, final String locale);
}
