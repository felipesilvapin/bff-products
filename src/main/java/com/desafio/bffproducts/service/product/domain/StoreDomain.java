package com.desafio.bffproducts.service.product.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class StoreDomain {
    List<ProductDomain> product;
}
