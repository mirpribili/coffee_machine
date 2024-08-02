package com.exe.coffeemachine.emulator.entity;

import lombok.Data;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author user
 * @year 2024
 */

@Entity
@Data
@Table(name = "usage_log")
public class UsageLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private CoffeeRecipe coffeeRecipe;

    private String status;
    private BigDecimal amount;
    private LocalDateTime createdAt;
}
