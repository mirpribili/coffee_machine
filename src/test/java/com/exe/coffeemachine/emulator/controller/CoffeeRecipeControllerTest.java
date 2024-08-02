package com.exe.coffeemachine.emulator.controller;

import com.exe.coffeemachine.emulator.dto.CoffeeRecipeDTO;
import com.exe.coffeemachine.emulator.entity.CoffeeRecipe;
import com.exe.coffeemachine.emulator.repository.CoffeeRecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author user
 * @year 2024
 */
@SpringBootTest
public class CoffeeRecipeControllerTest {

    @Mock
    private CoffeeRecipeRepository coffeeRecipeRepository;

    @InjectMocks
    private CoffeeRecipeController coffeeRecipeController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(coffeeRecipeController).build();
    }

    @Test
    public void testGetCoffeeRecipeById() throws Exception {
        CoffeeRecipe coffeeRecipe = new CoffeeRecipe();
        coffeeRecipe.setRecipeId(1L);
        coffeeRecipe.setName("Espresso");
        coffeeRecipe.setDescription("Strong coffee");

        when(coffeeRecipeRepository.findById(1L)).thenReturn(Optional.of(coffeeRecipe));

        ResponseEntity<CoffeeRecipeDTO> response = coffeeRecipeController.getCoffeeRecipeById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Espresso", response.getBody().getName());

        mockMvc.perform(get("/api/coffee-recipes/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateCoffeeRecipe() throws Exception {
        CoffeeRecipe coffeeRecipe = new CoffeeRecipe();
        coffeeRecipe.setRecipeId(1L);
        coffeeRecipe.setName("Latte");
        coffeeRecipe.setDescription("Coffee with milk");

        when(coffeeRecipeRepository.save(any(CoffeeRecipe.class))).thenReturn(coffeeRecipe);

        CoffeeRecipeDTO coffeeRecipeDTO = new CoffeeRecipeDTO();
        coffeeRecipeDTO.setName("Latte");
        coffeeRecipeDTO.setDescription("Coffee with milk");

        CoffeeRecipeDTO createdRecipe = coffeeRecipeController.createCoffeeRecipe(coffeeRecipeDTO);

        assertEquals("Latte", createdRecipe.getName());

        mockMvc.perform(post("/api/coffee-recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Latte\", \"description\": \"Coffee with milk\"}"))
                .andExpect(status().isOk());
    }
}
