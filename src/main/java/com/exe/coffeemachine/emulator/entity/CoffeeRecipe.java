package com.exe.coffeemachine.emulator.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
/**
 * @author user
 * @year 2024
 */
@Entity
@Data
@Table(name = "coffee_recipe", indexes = {
        @Index(name = "coffee_recipes_name_idx", columnList = "name")
})
public class CoffeeRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;

    private String name;

    private String description;

    @OneToMany(mappedBy = "coffeeRecipe", cascade = CascadeType.ALL)
    private List<RecipeIngredient> ingredients;

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
