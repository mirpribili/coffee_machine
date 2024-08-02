package com.exe.coffeemachine.emulator.controller;

import com.exe.coffeemachine.emulator.dto.CoffeeRecipeDTO;
import com.exe.coffeemachine.emulator.entity.CoffeeRecipe;
import com.exe.coffeemachine.emulator.exception.ResourceNotFoundException;
import com.exe.coffeemachine.emulator.mapper.CoffeeMachineMapper;
import com.exe.coffeemachine.emulator.repository.CoffeeRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Контроллер для управления рецептами кофе
 * @author user
 * @year 2024
 */
@RestController
@RequestMapping("/api/coffee-recipes")
@Tag(name = "Рецепты кофе", description = "API для управления рецептами кофе")
public class CoffeeRecipeController {

    @Autowired
    private CoffeeRecipeRepository coffeeRecipeRepository;

    @Autowired
    private CoffeeMachineMapper mapper;

    /**
     * Получить все рецепты кофе
     * @return Список всех рецептов кофе
     */
    @GetMapping
    @Operation(summary = "Получить все рецепты кофе", description = "Возвращает список всех доступных рецептов кофе")
    public List<CoffeeRecipeDTO> getAllCoffeeRecipes() {
        return coffeeRecipeRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Получить рецепт кофе по ID
     * @param recipeId ID рецепта
     * @return Рецепт кофе
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получить рецепт кофе по ID", description = "Возвращает рецепт кофе по указанному ID")
    public ResponseEntity<CoffeeRecipeDTO> getCoffeeRecipeById(@PathVariable(value = "id") Long recipeId) {
        CoffeeRecipe coffeeRecipe = coffeeRecipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Рецепт кофе не найден для id :: " + recipeId));
        return ResponseEntity.ok().body(mapper.toDTO(coffeeRecipe));
    }

    /**
     * Создать новый рецепт кофе
     * @param coffeeRecipeDTO Данные нового рецепта
     * @return Созданный рецепт кофе
     */
    @PostMapping
    @Operation(summary = "Создать новый рецепт кофе", description = "Создает новый рецепт кофе на основе предоставленных данных")
    public CoffeeRecipeDTO createCoffeeRecipe(@RequestBody CoffeeRecipeDTO coffeeRecipeDTO) {
        CoffeeRecipe coffeeRecipe = mapper.toEntity(coffeeRecipeDTO);
        CoffeeRecipe savedRecipe = coffeeRecipeRepository.save(coffeeRecipe);
        return mapper.toDTO(savedRecipe);
    }

    /**
     * Обновить существующий рецепт кофе
     * @param recipeId ID рецепта для обновления
     * @param coffeeRecipeDetails Новые данные рецепта
     * @return Обновленный рецепт кофе
     */
    @PutMapping("/{id}")
    @Operation(summary = "Обновить рецепт кофе", description = "Обновляет существующий рецепт кофе по указанному ID")
    public ResponseEntity<CoffeeRecipeDTO> updateCoffeeRecipe(@PathVariable(value = "id") Long recipeId,
                                                              @RequestBody CoffeeRecipeDTO coffeeRecipeDetails) {
        CoffeeRecipe coffeeRecipe = coffeeRecipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Рецепт кофе не найден для id :: " + recipeId));

        coffeeRecipe.setName(coffeeRecipeDetails.getName());
        coffeeRecipe.setDescription(coffeeRecipeDetails.getDescription());
        final CoffeeRecipe updatedCoffeeRecipe = coffeeRecipeRepository.save(coffeeRecipe);
        return ResponseEntity.ok(mapper.toDTO(updatedCoffeeRecipe));
    }

    /**
     * Удалить рецепт кофе
     * @param recipeId ID рецепта для удаления
     * @return Статус операции удаления
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить рецепт кофе", description = "Удаляет рецепт кофе по указанному ID")
    public Map<String, Boolean> deleteCoffeeRecipe(@PathVariable(value = "id") Long recipeId) {
        CoffeeRecipe coffeeRecipe = coffeeRecipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Рецепт кофе не найден для id :: " + recipeId));

        coffeeRecipeRepository.delete(coffeeRecipe);
        Map<String, Boolean> response = new HashMap<>();
        response.put("удалено", Boolean.TRUE);
        return response;
    }
}
