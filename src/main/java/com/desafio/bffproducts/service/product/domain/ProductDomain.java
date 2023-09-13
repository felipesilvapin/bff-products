package com.desafio.bffproducts.service.product.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDomain {
    @JsonProperty("id")
    int productId;
    String value;
    public double price;
    public int quantity;
}
