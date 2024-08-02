package com.exe.coffeemachine.emulator.controller;

import com.exe.coffeemachine.emulator.dto.CoffeeRecipeDTO;
import com.exe.coffeemachine.emulator.entity.CoffeeRecipe;
import com.exe.coffeemachine.emulator.exception.ResourceNotFoundException;
import com.exe.coffeemachine.emulator.mapper.CoffeeMachineMapper;
import com.exe.coffeemachine.emulator.repository.CoffeeRecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * @author user
 * @year 2024
 */
@ExtendWith(MockitoExtension.class)
public class CoffeeRecipeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CoffeeRecipeRepository coffeeRecipeRepository;

    @Mock
    private CoffeeMachineMapper mapper;

    @InjectMocks
    private CoffeeRecipeController coffeeRecipeController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(coffeeRecipeController).build();
    }

    @Test
    public void testGetAllCoffeeRecipes() throws Exception {
        CoffeeRecipeDTO coffeeRecipeDTO = new CoffeeRecipeDTO();
        coffeeRecipeDTO.setName("Espresso");
        coffeeRecipeDTO.setDescription("Strong coffee");

        when(coffeeRecipeRepository.findAll()).thenReturn(Collections.singletonList(new CoffeeRecipe()));
        when(mapper.toDTO(any(CoffeeRecipe.class))).thenReturn(coffeeRecipeDTO);

        mockMvc.perform(get("/api/coffee-recipes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Espresso"))
                .andExpect(jsonPath("$[0].description").value("Strong coffee"));
    }

    @Test
    public void testGetCoffeeRecipeById() throws Exception {
        CoffeeRecipeDTO coffeeRecipeDTO = new CoffeeRecipeDTO();
        coffeeRecipeDTO.setName("Latte");
        coffeeRecipeDTO.setDescription("Milky coffee");

        CoffeeRecipe coffeeRecipe = new CoffeeRecipe();
        coffeeRecipe.setName("Latte");
        coffeeRecipe.setDescription("Milky coffee");

        when(coffeeRecipeRepository.findById(anyLong())).thenReturn(Optional.of(coffeeRecipe));
        when(mapper.toDTO(any(CoffeeRecipe.class))).thenReturn(coffeeRecipeDTO);

        mockMvc.perform(get("/api/coffee-recipes/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Latte"))
                .andExpect(jsonPath("$.description").value("Milky coffee"));
    }

    @Test
    public void testCreateCoffeeRecipe() throws Exception {
        CoffeeRecipeDTO coffeeRecipeDTO = new CoffeeRecipeDTO();
        coffeeRecipeDTO.setName("Cappuccino");
        coffeeRecipeDTO.setDescription("Foamy coffee");

        CoffeeRecipe coffeeRecipe = new CoffeeRecipe();
        coffeeRecipe.setName("Cappuccino");
        coffeeRecipe.setDescription("Foamy coffee");

        when(mapper.toEntity(any(CoffeeRecipeDTO.class))).thenReturn(coffeeRecipe);
        when(coffeeRecipeRepository.save(any(CoffeeRecipe.class))).thenReturn(coffeeRecipe);
        when(mapper.toDTO(any(CoffeeRecipe.class))).thenReturn(coffeeRecipeDTO);

        mockMvc.perform(post("/api/coffee-recipes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Cappuccino\",\"description\":\"Foamy coffee\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Cappuccino"))
                .andExpect(jsonPath("$.description").value("Foamy coffee"));
    }

    @Test
    public void testUpdateCoffeeRecipe() throws Exception {
        CoffeeRecipeDTO coffeeRecipeDTO = new CoffeeRecipeDTO();
        coffeeRecipeDTO.setName("Mocha");
        coffeeRecipeDTO.setDescription("Chocolate coffee");

        CoffeeRecipe coffeeRecipe = new CoffeeRecipe();
        coffeeRecipe.setName("Mocha");
        coffeeRecipe.setDescription("Chocolate coffee");

        when(coffeeRecipeRepository.findById(anyLong())).thenReturn(Optional.of(coffeeRecipe));
        when(coffeeRecipeRepository.save(any(CoffeeRecipe.class))).thenReturn(coffeeRecipe);
        when(mapper.toDTO(any(CoffeeRecipe.class))).thenReturn(coffeeRecipeDTO);

        mockMvc.perform(put("/api/coffee-recipes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Mocha\",\"description\":\"Chocolate coffee\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Mocha"))
                .andExpect(jsonPath("$.description").value("Chocolate coffee"));
    }

    @Test
    public void testDeleteCoffeeRecipe() throws Exception {
        when(coffeeRecipeRepository.findById(anyLong())).thenReturn(Optional.of(new CoffeeRecipe()));
        doNothing().when(coffeeRecipeRepository).delete(any(CoffeeRecipe.class));

        mockMvc.perform(delete("/api/coffee-recipes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deleted").value(true));
    }
}
