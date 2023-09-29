package com.akash.productservice.controller;

import com.akash.productservice.Service.ProductService;
import com.akash.productservice.dto.ProductRequest;
import com.akash.productservice.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){

        productService.createProduct(productRequest);

    }
