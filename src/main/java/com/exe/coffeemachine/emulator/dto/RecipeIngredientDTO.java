package com.exe.coffeemachine.emulator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author user
 * @year 2024
 */
@Data
@Schema(
        name = "Ингредиент рецепта",
        description = "DTO для представления ингредиента в рецепте"
)
public class RecipeIngredientDTO {

    @Schema(
            description = "Уникальный идентификатор записи ингредиента рецепта",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Идентификатор рецепта кофе",
            example = "1"
    )
    private Long coffeeRecipeId;

    @Schema(
            description = "Идентификатор ингредиента",
            example = "1"
    )
    private Long ingredientId;

    @Schema(
            description = "Информация о рецепте кофе",
            implementation = CoffeeRecipeDTO.class
    )
    private CoffeeRecipeDTO coffeeRecipe;

    @Schema(
            description = "Информация о ингредиенте",
            implementation = IngredientDTO.class
    )
    private IngredientDTO ingredient;

    @Schema(
            description = "Количество ингредиента в рецепте",
            example = "10"
    )
    private BigDecimal amount;

    @Schema(
            description = "Дата и время создания записи ингредиента рецепта",
            example = "2024-08-02T15:13:10.557416"
    )
    private LocalDateTime createdAt;

    @Schema(
            description = "Дата и время последнего обновления записи ингредиента рецепта",
            example = "2024-08-02T15:13:10.557416"
    )
    private LocalDateTime updatedAt;
}
