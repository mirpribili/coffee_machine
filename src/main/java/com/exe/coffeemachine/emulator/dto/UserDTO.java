package com.exe.coffeemachine.emulator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(
        name = "Пользователь",
        description = "Схема для хранения информации о пользователе"
)
public class UserDTO {

    @Schema(description = "Уникальный идентификатор пользователя", example = "1")
    private Long userId;  // Изменено с id на userId

    @NotEmpty(message = "Имя пользователя не может быть пустым")
    @Schema(description = "Имя пользователя", example = "ivan_petrov")
    private String username;

    @NotEmpty(message = "Email не может быть пустым")
    @Email(message = "Некорректный формат email")
    @Schema(description = "Email пользователя", example = "ivan@example.com")
    private String email;

    @Schema(description = "Дата создания учетной записи", example = "2024-01-01T12:00:00")
    private String createdAt;

    @Schema(description = "Дата последнего обновления учетной записи", example = "2024-01-01T12:00:00")
    private String updatedAt;
}
