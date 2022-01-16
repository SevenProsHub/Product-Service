package com.example.productservice.services;

import com.example.productservice.dto.ProductCreateDto;
import com.example.productservice.entities.Product;
import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public Product save(ProductCreateDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        return productRepository.save(product);
    }

    public Product get(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new NotFoundException( productId , "Product"));
    }

    public Iterable<Product> getAll(Map<String, String>map) {
        if(map.containsKey("search")){
            return productRepository.findAllBySearch(map.get("search"));
        }
        return productRepository.findAll();
    }
}
