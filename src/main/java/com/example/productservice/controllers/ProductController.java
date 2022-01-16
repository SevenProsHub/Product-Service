package com.example.productservice.controllers;

import com.example.productservice.dto.ProductCreateDto;
import com.example.productservice.entities.Product;
import com.example.productservice.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/products/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<Product> getProduct(@PathVariable("product_id") Long productId){
        return ResponseEntity.ok(productService.get(productId));
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> getAllProduct(@RequestParam Map<String,String> map){
        return ResponseEntity.ok(productService.getAll(map));
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductCreateDto product){
        return ResponseEntity.created(URI.create("/products/"+ productService.save(product).getId())).build();
    }
}
