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
@Table(name = "recipe_ingredient")
@IdClass(RecipeIngredientId.class)
public class RecipeIngredient {

    @Id
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private CoffeeRecipe coffeeRecipe;

    @Id
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(nullable = false) // Обеспечиваем, что поле не может быть null
    private BigDecimal amount;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}