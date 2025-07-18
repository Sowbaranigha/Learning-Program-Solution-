package com.example.productservice.controller; // ✅ Change this if your package is different

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing products.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    /**
     * Get a list of available products.
     * @return List of product names
     */
    @GetMapping
    public List<String> getProducts() {
        return List.of("Laptop", "Phone", "Tablet");
    }
}
