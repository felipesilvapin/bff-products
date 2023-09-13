package com.desafio.bffproducts.repository.feign.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDataEntity {
    int id;
    ProductAttributesEntity attributes;
}
