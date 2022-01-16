package com.example.productservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProductCreateDto {
    private Long id;

    @NotNull(message = "name is required")
    private String name;

    @NotNull(message = "info is required")
    private String info;

    @NotNull(message = "price is required")
    private float price;
}
