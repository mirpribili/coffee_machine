package com.exe.coffeemachine.emulator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author user
 * @year 2024
 */
@Data
@Schema(
        name = "Ингредиент",
        description = "DTO для представления ингредиента"
)
public class IngredientDTO {

    @Schema(
            description = "Уникальный идентификатор ингредиента",
            example = "1"
    )
    private Long ingredientId;

    @Schema(
            description = "Название ингредиента",
            example = "Кофе"
    )
    private String name;

    @Schema(
            description = "Текущее количество ингредиента",
            example = "1000"
    )
    private Integer currentQuantity;

    @Schema(
            description = "Минимально допустимое количество ингредиента",
            example = "200"
    )
    private Integer minQuantity;

    @Schema(
            description = "Дата и время создания ингредиента",
            example = "2024-08-02T15:13:10.557416"
    )
    private LocalDateTime createdAt;

    @Schema(
            description = "Дата и время последнего обновления ингредиента",
            example = "2024-08-02T15:13:10.557416"
    )
    private LocalDateTime updatedAt;
}
