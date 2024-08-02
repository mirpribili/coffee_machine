package com.exe.coffeemachine.emulator.repository;

import com.exe.coffeemachine.emulator.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 * @year 2024
 */

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, Long> {
}