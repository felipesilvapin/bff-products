package com.desafio.bffproducts.repository.feign.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributesEntity {
    Date createdAt;
    Date updatedAt;
    Date publishedAt;
    List<ProductEntity> products;
}
