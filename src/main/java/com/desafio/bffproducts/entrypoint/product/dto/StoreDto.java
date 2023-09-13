package com.desafio.bffproducts.entrypoint.product.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDto {
    @NotNull(message = "")
    @NotEmpty(message = "")
    List<ProductDto> product;
}
