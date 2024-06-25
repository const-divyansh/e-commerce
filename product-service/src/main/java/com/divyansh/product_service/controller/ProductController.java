package com.divyansh.product_service.controller;

import com.divyansh.product_service.dto.ProductRequest;
import com.divyansh.product_service.dto.ProductResponse;
import com.divyansh.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private  final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String createProduct (@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        return "Product Created";
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> gerAllProducts(){
        return productService.getAllProducts();
    }

}
