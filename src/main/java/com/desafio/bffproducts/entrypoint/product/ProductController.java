package com.desafio.bffproducts.entrypoint.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/store")
@RequiredArgsConstructor
public class ProductController {
}
