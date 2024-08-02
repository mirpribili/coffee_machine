package com.exe.coffeemachine.emulator.dto;

/**
 * @author user
 * @year 2024
 */
import lombok.Data;

@Data
public class CoffeeRecipeDTO {
    private Long recipeId;
    private String name;
    private String description;
}