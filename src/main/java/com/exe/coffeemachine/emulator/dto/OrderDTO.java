package com.exe.coffeemachine.emulator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(
        name = "Заказ на кофе",
        description = "DTO для размещения заказа на кофе"
)
public class OrderDTO {

    @NotNull(message = "recipeId не может быть null")
    @Schema(
            description = "ID рецепта кофе",
            example = "1"
    )
    private Long recipeId;

    @NotNull(message = "userId не может быть null")
    @Schema(
            description = "ID пользователя",
            example = "1"
    )
    private Long userId;

    @Schema(
            description = "Флаг добавления дополнительного сахара",
            example = "true"
    )
    private boolean extraSugar;
}
