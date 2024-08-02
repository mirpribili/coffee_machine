package com.exe.coffeemachine.emulator.controller;

import com.exe.coffeemachine.emulator.dto.CoffeeRecipeDTO;
import com.exe.coffeemachine.emulator.entity.CoffeeRecipe;
import com.exe.coffeemachine.emulator.repository.CoffeeRecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * @author user
 * @year 2024
 */
@Transactional
@Rollback
@SpringBootTest
public class CoffeeRecipeControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CoffeeRecipeRepository coffeeRecipeRepository;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetCoffeeRecipeById() throws Exception {
        CoffeeRecipe coffeeRecipe = new CoffeeRecipe();
        coffeeRecipe.setName("Espresso");
        coffeeRecipe.setDescription("Strong coffee");
        coffeeRecipe = coffeeRecipeRepository.save(coffeeRecipe);

        mockMvc.perform(get("/api/coffee-recipes/" + coffeeRecipe.getRecipeId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateCoffeeRecipe() throws Exception {
        String coffeeRecipeJson = "{\"name\": \"Latte\", \"description\": \"Coffee with milk\"}";

        mockMvc.perform(post("/api/coffee-recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(coffeeRecipeJson))
                .andExpect(status().isOk());
    }
}
