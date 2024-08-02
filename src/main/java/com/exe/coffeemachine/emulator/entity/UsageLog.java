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
    @JoinColumn(name = "user_id", nullable = true) // Указываем, что поле может быть null
    private User user;

    @ManyToOne
    @JoinColumn(name = "recipe_id", nullable = true) // Указываем, что поле может быть null
    private CoffeeRecipe coffeeRecipe;

    @Column(length = 20) // Указываем максимальную длину для поля status
    private String status;

    @Column(precision = 10, scale = 2) // Указываем точность для поля amount
    private BigDecimal amount;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
