package com.exe.coffeemachine.emulator.controller;

import com.exe.coffeemachine.emulator.dto.OrderDTO;
import com.exe.coffeemachine.emulator.entity.UsageLog;
import com.exe.coffeemachine.emulator.service.CoffeeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Контроллер для размещения заказов на кофе
 * @author user
 * @year 2024
 */
@RestController
@RequestMapping("/api/orders")
@Tag(name = "Заказы", description = "API для размещения заказов на кофе")
public class OrderController {

    @Autowired
    private CoffeeOrderService coffeeOrderService;

    @Operation(summary = "Разместить заказ на кофе", responses = {
            @ApiResponse(responseCode = "200", description = "Заказ успешно размещен"),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос")
    })
    @PostMapping
    public ResponseEntity<String> placeOrder(
            @RequestBody @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Данные для размещения заказа",
                    required = true,
                    content = @Content(
                            schema = @Schema(
                                    implementation = OrderDTO.class,
                                    example = "{\"recipeId\": 1, \"userId\": 1, \"extraSugar\": true}"
                            )
                    )
            ) OrderDTO orderDTO) {
        try {
            UsageLog log = coffeeOrderService.placeOrder(orderDTO);
            return ResponseEntity.ok("Заказ успешно размещен. Лог ID: " + log.getLogId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
