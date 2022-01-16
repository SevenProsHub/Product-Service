package com.example.productservice.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id, String type){
        super(type + " not found with id: " + id);
    }
}
