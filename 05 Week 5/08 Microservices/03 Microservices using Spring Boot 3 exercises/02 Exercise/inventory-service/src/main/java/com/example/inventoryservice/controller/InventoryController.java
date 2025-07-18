package com.example.inventoryservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping("/{productId}")
    public String checkStock(@PathVariable("productId") String productId) {
        // In real use, you'd query a database or service for actual stock
        return "✅ Stock available for product: " + productId;
    }
}
