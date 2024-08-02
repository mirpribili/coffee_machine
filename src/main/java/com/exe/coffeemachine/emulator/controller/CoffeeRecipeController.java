package com.exe.coffeemachine.emulator.controller;

import com.exe.coffeemachine.emulator.entity.CoffeeRecipe;
import com.exe.coffeemachine.emulator.exception.ResourceNotFoundException;
import com.exe.coffeemachine.emulator.repository.CoffeeRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author user
 * @year 2024
 */

@RestController
@RequestMapping("/api/coffee-recipes")
public class CoffeeRecipeController {

    @Autowired
    private CoffeeRecipeRepository coffeeRecipeRepository;

    @GetMapping
    public List<CoffeeRecipe> getAllCoffeeRecipes() {
        return coffeeRecipeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeRecipe> getCoffeeRecipeById(@PathVariable(value = "id") Long recipeId) {
        CoffeeRecipe coffeeRecipe = coffeeRecipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("CoffeeRecipe not found for this id :: " + recipeId));
        return ResponseEntity.ok().body(coffeeRecipe);
    }

    @PostMapping
    public CoffeeRecipe createCoffeeRecipe(@RequestBody CoffeeRecipe coffeeRecipe) {
        return coffeeRecipeRepository.save(coffeeRecipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoffeeRecipe> updateCoffeeRecipe(@PathVariable(value = "id") Long recipeId,
                                                           @RequestBody CoffeeRecipe coffeeRecipeDetails) {
        CoffeeRecipe coffeeRecipe = coffeeRecipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("CoffeeRecipe not found for this id :: " + recipeId));

        coffeeRecipe.setName(coffeeRecipeDetails.getName());
        coffeeRecipe.setDescription(coffeeRecipeDetails.getDescription());
        final CoffeeRecipe updatedCoffeeRecipe = coffeeRecipeRepository.save(coffeeRecipe);
        return ResponseEntity.ok(updatedCoffeeRecipe);
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