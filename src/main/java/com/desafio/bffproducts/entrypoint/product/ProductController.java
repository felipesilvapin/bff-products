package com.desafio.bffproducts.entrypoint.product;

import com.desafio.bffproducts.entrypoint.product.dto.ProductDto;
import com.desafio.bffproducts.entrypoint.product.dto.StoreDto;
import com.desafio.bffproducts.entrypoint.product.mapper.IProductEntrypointMapper;
import com.desafio.bffproducts.service.product.contracts.IProductService;
import com.desafio.bffproducts.service.product.domain.ProductDomain;
import com.desafio.bffproducts.service.product.domain.StoreDomain;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/store")
@RequiredArgsConstructor
public class ProductController {
    private final IProductEntrypointMapper productEntrypointMapper;
    private final IProductService productService;

    @GetMapping
    @Operation(summary = "Get products", description = "Return products in the store",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success"),
                    @ApiResponse(responseCode = "204", description = "No Content")
            })
    public @ResponseBody ResponseEntity<StoreDto> getProducts(
            final @RequestHeader(value = "Accept-Language", required = false, defaultValue = "en-US")
            @Schema(name = "language", example = "en-US") String locale) {
        final ResponseEntity<StoreDomain> responseDomain = productService.getProducts(locale);
        ResponseEntity<StoreDto> responseEntity;

        if (responseDomain != null) {
            responseEntity = ResponseEntity.ok(productEntrypointMapper.storeDomainToDto(responseDomain.getBody()));
        } else {
            final StoreDto storeDto = new StoreDto();
            responseEntity = ResponseEntity.ok(storeDto);
        }
        return responseEntity;
    };

    @GetMapping("/{productId}")
    @Operation(summary = "Product details",
            description = "Given product id return product details.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Ok"),
                    @ApiResponse(responseCode = "422", description = "Parâmetro inválido"),
                    @ApiResponse(responseCode = "502", description = "Erro de conexão com API externa"),
                    @ApiResponse(responseCode = "500", description = "Erro genérico")})
    public @ResponseBody ResponseEntity<ProductDto> getProductDetails(
            final @PathVariable String productId,
            final @RequestHeader(value = "Accept-Language", required = false, defaultValue = "en-US")
            @Schema(name = "language", example = "en-US") String locale) {
        final ResponseEntity<ProductDomain> responseDomain = productService.getProductById(productId, locale);
        ResponseEntity<ProductDto> responseEntity;

        if (responseDomain != null) {
            responseEntity = ResponseEntity.ok(productEntrypointMapper.productDomainToDto(responseDomain.getBody()));
        } else {
            final ProductDto productDto = new ProductDto();
            responseEntity = ResponseEntity.ok(productDto);
        }
        return responseEntity;
    }
}
