package com.exe.coffeemachine.emulator.entity;

import lombok.Data;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author user
 * @year 2024
 */

@Entity
@Data
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;

    private String name;
    private BigDecimal currentQuantity;
    private BigDecimal minQuantity;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL)
    private List<RecipeIngredient> recipeIngredients;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}