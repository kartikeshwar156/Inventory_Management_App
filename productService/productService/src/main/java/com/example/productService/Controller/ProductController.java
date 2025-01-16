package com.example.productService.Controller;

import com.example.productService.Dto.ProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // fir getting the response
    public void creteProduct(@RequestBody ProductRequest productRequest)
}
