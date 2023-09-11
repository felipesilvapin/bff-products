package com.desafio.bffproducts.repository.feign.client;

import com.desafio.bffproducts.repository.feign.entity.ProductResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "strapi-service", url = "${feign.client.config.strapi.api.baseurl}")
public interface IStrapiFeignClient {
    @Headers("Content-Type: application/json")
    @GetMapping("/api/store")
    ProductResponse getProducts(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestParam(value = "populate", defaultValue = "*", required = false) String populate,
            @RequestParam(value = "locale", defaultValue = "en-US", required = false) String locale);
}