package com.exe.coffeemachine.emulator.service.impl;

import com.exe.coffeemachine.emulator.dto.OrderDTO;
import com.exe.coffeemachine.emulator.entity.*;
import com.exe.coffeemachine.emulator.repository.*;
import com.exe.coffeemachine.emulator.service.CoffeeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Реализация сервиса для размещения заказов на кофе
 * @year 2024
 */
@Service
public class CoffeeOrderServiceImpl implements CoffeeOrderService {

    @Autowired
    private CoffeeRecipeRepository coffeeRecipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private UsageLogRepository usageLogRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ErrorLogRepository errorLogRepository;

    @Override
    @Transactional
    public UsageLog placeOrder(OrderDTO orderDTO) throws Exception {
        // Проверка наличия рецепта
        CoffeeRecipe recipe = coffeeRecipeRepository.findById(orderDTO.getRecipeId())
                .orElseThrow(() -> new Exception("Рецепт не найден"));

        // Проверка наличия ингредиентов
        for (RecipeIngredient recipeIngredient : recipe.getIngredients()) {
            Optional<Ingredient> ingredientOpt = ingredientRepository.findById(recipeIngredient.getIngredientId());
            if (ingredientOpt.isEmpty() || ingredientOpt.get().getCurrentQuantity().compareTo(recipeIngredient.getAmount()) < 0) {
                throw new Exception("Недостаточно ингредиентов для рецепта");
            }
        }

        // Обновление количества ингредиентов
        for (RecipeIngredient recipeIngredient : recipe.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findById(recipeIngredient.getIngredientId())
                    .orElseThrow(() -> new Exception("Ингредиент не найден"));
            ingredient.setCurrentQuantity(ingredient.getCurrentQuantity().subtract(recipeIngredient.getAmount()));
            ingredientRepository.save(ingredient);
        }

        // Создание записи в логе
        UsageLog log = new UsageLog();
        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new Exception("Пользователь не найден"));

        log.setUser(user);
        log.setCoffeeRecipe(recipe);
        log.setStatus("SUCCESS");
        log.setAmount(BigDecimal.ZERO); // Можно установить реальную сумму если необходимо
        usageLogRepository.save(log);

        return log;
    }
}
