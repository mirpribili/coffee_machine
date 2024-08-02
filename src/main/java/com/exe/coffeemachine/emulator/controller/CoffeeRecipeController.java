package com.exe.coffeemachine.emulator.controller;

import com.exe.coffeemachine.emulator.dto.CoffeeRecipeDTO;
import com.exe.coffeemachine.emulator.entity.CoffeeRecipe;
import com.exe.coffeemachine.emulator.exception.ResourceNotFoundException;
import com.exe.coffeemachine.emulator.repository.CoffeeRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author user
 * @year 2024
 */

@RestController
@RequestMapping("/api/coffee-recipes")
public class CoffeeRecipeController {

    @Autowired
    private CoffeeRecipeRepository coffeeRecipeRepository;

    // Преобразование сущности в DTO
    private CoffeeRecipeDTO convertToDTO(CoffeeRecipe coffeeRecipe) {
        CoffeeRecipeDTO dto = new CoffeeRecipeDTO();
        dto.setRecipeId(coffeeRecipe.getRecipeId());
        dto.setName(coffeeRecipe.getName());
        dto.setDescription(coffeeRecipe.getDescription());
        return dto;
    }

    // Преобразование DTO в сущность
    private CoffeeRecipe convertToEntity(CoffeeRecipeDTO dto) {
        CoffeeRecipe coffeeRecipe = new CoffeeRecipe();
        coffeeRecipe.setRecipeId(dto.getRecipeId());
        coffeeRecipe.setName(dto.getName());
        coffeeRecipe.setDescription(dto.getDescription());
        return coffeeRecipe;
    }

    @GetMapping
    public List<CoffeeRecipeDTO> getAllCoffeeRecipes() {
        return coffeeRecipeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeRecipeDTO> getCoffeeRecipeById(@PathVariable(value = "id") Long recipeId) {
        CoffeeRecipe coffeeRecipe = coffeeRecipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("CoffeeRecipe not found for this id :: " + recipeId));
        return ResponseEntity.ok().body(convertToDTO(coffeeRecipe));
    }

    @PostMapping
    public CoffeeRecipeDTO createCoffeeRecipe(@RequestBody CoffeeRecipeDTO coffeeRecipeDTO) {
        CoffeeRecipe coffeeRecipe = convertToEntity(coffeeRecipeDTO);
        CoffeeRecipe savedRecipe = coffeeRecipeRepository.save(coffeeRecipe);
        return convertToDTO(savedRecipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoffeeRecipeDTO> updateCoffeeRecipe(@PathVariable(value = "id") Long recipeId,
                                                              @RequestBody CoffeeRecipeDTO coffeeRecipeDetails) {
        CoffeeRecipe coffeeRecipe = coffeeRecipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("CoffeeRecipe not found for this id :: " + recipeId));

        coffeeRecipe.setName(coffeeRecipeDetails.getName());
        coffeeRecipe.setDescription(coffeeRecipeDetails.getDescription());
        final CoffeeRecipe updatedCoffeeRecipe = coffeeRecipeRepository.save(coffeeRecipe);
        return ResponseEntity.ok(convertToDTO(updatedCoffeeRecipe));
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCoffeeRecipe(@PathVariable(value = "id") Long recipeId) {
        CoffeeRecipe coffeeRecipe = coffeeRecipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("CoffeeRecipe not found for this id :: " + recipeId));

        coffeeRecipeRepository.delete(coffeeRecipe);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
