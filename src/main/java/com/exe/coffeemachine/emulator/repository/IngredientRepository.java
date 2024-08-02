package com.exe.coffeemachine.emulator.repository;

import com.exe.coffeemachine.emulator.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 * @year 2024
 */
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}