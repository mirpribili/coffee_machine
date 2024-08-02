package com.exe.coffeemachine.emulator.mapper;

import com.exe.coffeemachine.emulator.dto.CoffeeRecipeDTO;
import com.exe.coffeemachine.emulator.entity.CoffeeRecipe;
import org.springframework.stereotype.Component;

@Component
public class CoffeeRecipeMapper {

    public CoffeeRecipeDTO toDTO(CoffeeRecipe coffeeRecipe) {
        CoffeeRecipeDTO dto = new CoffeeRecipeDTO();
        dto.setRecipeId(coffeeRecipe.getRecipeId());
        dto.setName(coffeeRecipe.getName());
        dto.setDescription(coffeeRecipe.getDescription());
        // Установите другие поля, если это необходимо
        dto.setCreatedAt(coffeeRecipe.getCreatedAt().toString());
        dto.setUpdatedAt(coffeeRecipe.getUpdatedAt().toString());
        return dto;
    }
}
