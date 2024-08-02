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
/**
 * @author user
 * @year 2024
 */
@RestController
@RequestMapping("/api/coffee-recipes")
public class CoffeeRecipeController {

    @Autowired
    private CoffeeRecipeRepository coffeeRecipeRepository;

    @Autowired
    private CoffeeMachineMapper mapper;

    @GetMapping
    public List<CoffeeRecipeDTO> getAllCoffeeRecipes() {
        return coffeeRecipeRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeRecipeDTO> getCoffeeRecipeById(@PathVariable(value = "id") Long recipeId) {
        CoffeeRecipe coffeeRecipe = coffeeRecipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("CoffeeRecipe not found for this id :: " + recipeId));
        return ResponseEntity.ok().body(mapper.toDTO(coffeeRecipe));
    }

    @PostMapping
    public CoffeeRecipeDTO createCoffeeRecipe(@RequestBody CoffeeRecipeDTO coffeeRecipeDTO) {
        CoffeeRecipe coffeeRecipe = mapper.toEntity(coffeeRecipeDTO);
        CoffeeRecipe savedRecipe = coffeeRecipeRepository.save(coffeeRecipe);
        return mapper.toDTO(savedRecipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoffeeRecipeDTO> updateCoffeeRecipe(@PathVariable(value = "id") Long recipeId,
                                                              @RequestBody CoffeeRecipeDTO coffeeRecipeDetails) {
        CoffeeRecipe coffeeRecipe = coffeeRecipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("CoffeeRecipe not found for this id :: " + recipeId));

        coffeeRecipe.setName(coffeeRecipeDetails.getName());
        coffeeRecipe.setDescription(coffeeRecipeDetails.getDescription());
        final CoffeeRecipe updatedCoffeeRecipe = coffeeRecipeRepository.save(coffeeRecipe);
        return ResponseEntity.ok(mapper.toDTO(updatedCoffeeRecipe));
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
