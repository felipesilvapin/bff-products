package com.desafio.bffproducts.entrypoint.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    @JsonProperty("id")
    int productId;
    String value;
    public double price;
    public int quantity;
}
