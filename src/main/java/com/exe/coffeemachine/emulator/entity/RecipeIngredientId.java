package com.exe.coffeemachine.emulator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author user
 * @year 2024
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredientId implements Serializable {
    private Long coffeeRecipe; // Предполагаем, что тип ID - Long
    private Long ingredient;   // Предполагаем, что тип ID - Long
}
