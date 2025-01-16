package com.example.productService.Dto;

import java.math.BigDecimal;

public record ProductRequest(String id,String name, String description, BigDecimal price) {
}
