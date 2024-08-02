package com.exe.coffeemachine.emulator.repository;

import com.exe.coffeemachine.emulator.entity.CoffeeRecipe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 * @year 2024
 */
public interface CoffeeRecipeRepository extends JpaRepository<CoffeeRecipe, Long> {
}
