package com.exe.coffeemachine.emulator.mapper;

import com.exe.coffeemachine.emulator.dto.CoffeeRecipeDTO;
import com.exe.coffeemachine.emulator.dto.UserDTO;
import com.exe.coffeemachine.emulator.entity.CoffeeRecipe;
import com.exe.coffeemachine.emulator.entity.User;
/**
 * @author user
 * @year 2024
 */
public interface CoffeeMachineMapper {

    CoffeeRecipeDTO toDTO(CoffeeRecipe coffeeRecipe);

    CoffeeRecipe toEntity(CoffeeRecipeDTO coffeeRecipeDTO);

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
