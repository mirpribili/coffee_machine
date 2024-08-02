package com.exe.coffeemachine.emulator.mapper;

import com.exe.coffeemachine.emulator.dto.CoffeeRecipeDTO;
import com.exe.coffeemachine.emulator.dto.UserDTO;
import com.exe.coffeemachine.emulator.entity.CoffeeRecipe;
import com.exe.coffeemachine.emulator.entity.User;
import org.springframework.stereotype.Component;

/**
 * Реализация маппера для преобразования между DTO и сущностями
 * @author user
 * @year 2024
 */
@Component
public class CoffeeMachineMapperImpl implements CoffeeMachineMapper {

    @Override
    public CoffeeRecipeDTO toDTO(CoffeeRecipe coffeeRecipe) {
        if (coffeeRecipe == null) {
            return null;
        }
        CoffeeRecipeDTO dto = new CoffeeRecipeDTO();
        dto.setRecipeId(coffeeRecipe.getRecipeId());
        dto.setName(coffeeRecipe.getName());
        dto.setDescription(coffeeRecipe.getDescription());
        return dto;
    }

    @Override
    public CoffeeRecipe toEntity(CoffeeRecipeDTO coffeeRecipeDTO) {
        if (coffeeRecipeDTO == null) {
            return null;
        }
        CoffeeRecipe coffeeRecipe = new CoffeeRecipe();
        coffeeRecipe.setRecipeId(coffeeRecipeDTO.getRecipeId());
        coffeeRecipe.setName(coffeeRecipeDTO.getName());
        coffeeRecipe.setDescription(coffeeRecipeDTO.getDescription());
        return coffeeRecipe;
    }

    @Override
    public UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        // Добавьте здесь преобразование createdAt и updatedAt, если необходимо
        return dto;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        // Добавьте здесь преобразование createdAt и updatedAt, если необходимо
        return user;
    }
}
