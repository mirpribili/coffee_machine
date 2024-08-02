package com.exe.coffeemachine.emulator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * DTO для рецепта кофе
 * @author user
 * @year 2024
 */
@Data
@Schema(
        name = "Рецепт кофе",
        description = "Схема для хранения информации о рецепте кофе"
)
public class CoffeeRecipeDTO {

    @Schema(
            description = "Уникальный идентификатор рецепта",
            example = "1"
    )
    private Long recipeId;

    @NotEmpty(message = "Название рецепта не может быть пустым")
    @Schema(
            description = "Название рецепта кофе",
            example = "Капучино"
    )
    private String name;

    @Schema(
            description = "Описание рецепта кофе",
            example = "Классический капучино с молочной пеной"
    )
    private String description;

    // Можно добавить дополнительные поля, если они есть в вашей базе данных
    @Schema(
            description = "Дата создания рецепта",
            example = "2024-01-01T12:00:00"
    )
    private String createdAt;

    @Schema(
            description = "Дата последнего обновления рецепта",
            example = "2024-01-01T12:00:00"
    )
    private String updatedAt;
}
