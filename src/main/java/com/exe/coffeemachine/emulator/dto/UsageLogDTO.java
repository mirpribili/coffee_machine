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
        name = "Лог использования",
        description = "DTO для логирования использования кофе-машины"
)
public class UsageLogDTO {

    @Schema(
            description = "Уникальный идентификатор лога",
            example = "1"
    )
    private Long logId;

    @Schema(
            description = "Информация о пользователе",
            implementation = UserDTO.class
    )
    private UserDTO user;

    @Schema(
            description = "Информация о рецепте кофе",
            implementation = CoffeeRecipeDTO.class
    )
    private CoffeeRecipeDTO coffeeRecipe;

    @Schema(
            description = "Статус выполнения заказа",
            example = "успешно"
    )
    private String status;

    @Schema(
            description = "Сумма использованных ингредиентов",
            example = "100.00"
    )
    private BigDecimal amount;

    @Schema(
            description = "Дата и время создания лога",
            example = "2024-08-02T15:13:10.557416"
    )
    private LocalDateTime createdAt;
}
