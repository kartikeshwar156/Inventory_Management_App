package com.example.productService.Service;

import com.example.productService.Dto.ProductRequest;
import com.example.productService.Dto.ProductResponse;
import com.example.productService.Model.Product;
import com.example.productService.Repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    public ProductResponse createProduct(ProductRequest productrequest){
        Product product = Product.builder()
                .name(productrequest.name())
                .description(productrequest.description())
                .price(productrequest.price())
                .build();

        productRepository.save(product);
        log.info("Product saved successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());

    }

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product ->  new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
