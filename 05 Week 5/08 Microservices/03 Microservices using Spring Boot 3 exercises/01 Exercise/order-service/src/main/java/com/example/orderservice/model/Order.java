package com.example.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private int quantity;

    private double price;

    private Long userId; // Refers to a user (no foreign key needed for now)
}
