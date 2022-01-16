package com.example.productservice.repositories;

import com.example.productservice.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("SELECT p FROM Product p where p.name LIKE %:search% OR p.info LIKE %:search%")
    Iterable<Product> findAllBySearch(String search);
}
