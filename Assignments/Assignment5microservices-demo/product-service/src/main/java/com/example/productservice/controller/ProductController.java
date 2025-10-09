package com.example.productservice.controller;

import com.example.productservice.ProductServiceApplication;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServiceApplication productServiceApplication;
    
    @Autowired
    private ProductRepository productRepository;

    ProductController(ProductServiceApplication productServiceApplication) {
        this.productServiceApplication = productServiceApplication;
    }
    
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
    	return productRepository.findById(id).get();
    }
    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
    	return productRepository.save(product);
    }
    
    @GetMapping("/createsampleproduct")
    public Product createSampleProduct() {
    	Product product = new Product();
    	product.setId(1);
    	product.setName("Sample Peoduct");
    	return productRepository.save(product);
    }
    
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
    	return productRepository.save(productDetails);
    }
    
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}