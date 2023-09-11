package com.desafio.bffproducts.repository.feign.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAttributes {
    public Date createdAt;
    public Date updatedAt;
    public Date publishedAt;
    public List<Product> products;
}
