package com.exe.coffeemachine.emulator.controller;

import com.exe.coffeemachine.emulator.dto.UserDTO;
import com.exe.coffeemachine.emulator.entity.User;
import com.exe.coffeemachine.emulator.exception.ResourceNotFoundException;
import com.exe.coffeemachine.emulator.mapper.CoffeeMachineMapper;
import com.exe.coffeemachine.emulator.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для управления пользователями
 * @author user
 * @year 2024
 */
@RestController
@RequestMapping("/users")
@Tag(name = "Пользователи", description = "API для управления пользователями")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CoffeeMachineMapper mapper;

    @GetMapping
    @Operation(summary = "Получить всех пользователей", description = "Возвращает список всех пользователей")
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    @Operation(summary = "Создать нового пользователя", description = "Создает нового пользователя")
    @ApiResponse(responseCode = "200", description = "Пользователь успешно создан",
            content = @Content(schema = @Schema(implementation = UserDTO.class)))
    public UserDTO createUser(
            @Parameter(description = "Данные нового пользователя")
            @RequestBody UserDTO userDTO) {
        User user = mapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return mapper.toDTO(savedUser);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить пользователя по ID", description = "Возвращает пользователя по его ID")
    @ApiResponse(responseCode = "200", description = "Пользователь найден",
            content = @Content(schema = @Schema(implementation = UserDTO.class)))
    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    public UserDTO getUserById(
            @Parameter(description = "ID пользователя")
            @PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден"));
        return mapper.toDTO(user);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Обновить пользователя", description = "Обновляет данные существующего пользователя")
    @ApiResponse(responseCode = "200", description = "Пользователь успешно обновлен",
            content = @Content(schema = @Schema(implementation = UserDTO.class)))
    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    public UserDTO updateUser(
            @Parameter(description = "ID пользователя")
            @PathVariable Long id,
            @Parameter(description = "Обновленные данные пользователя")
            @RequestBody UserDTO userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден"));

        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());

        User updatedUser = userRepository.save(user);
        return mapper.toDTO(updatedUser);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить пользователя", description = "Удаляет пользователя по его ID")
    @ApiResponse(responseCode = "200", description = "Пользователь успешно удален")
    @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    public void deleteUser(
            @Parameter(description = "ID пользователя")
            @PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Пользователь не найден"));
        userRepository.delete(user);
    }
}
