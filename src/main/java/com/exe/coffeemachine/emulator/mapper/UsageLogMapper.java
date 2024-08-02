package com.exe.coffeemachine.emulator.mapper;

import com.exe.coffeemachine.emulator.dto.CoffeeRecipeDTO;
import com.exe.coffeemachine.emulator.dto.UserDTO;
import com.exe.coffeemachine.emulator.dto.UsageLogDTO;
import com.exe.coffeemachine.emulator.entity.UsageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsageLogMapper {

    @Autowired
    private CoffeeRecipeMapper coffeeRecipeMapper; // Добавьте этот маппер

    public UsageLogDTO toDTO(UsageLog log) {
        UsageLogDTO dto = new UsageLogDTO();
        dto.setLogId(log.getLogId());
        dto.setStatus(log.getStatus());
        dto.setAmount(log.getAmount());
        dto.setCreatedAt(log.getCreatedAt());

        if (log.getUser() != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(log.getUser().getUserId());
            userDTO.setUsername(log.getUser().getUsername());
            userDTO.setEmail(log.getUser().getEmail());
            userDTO.setCreatedAt(log.getUser().getCreatedAt().toString());
            userDTO.setUpdatedAt(log.getUser().getUpdatedAt().toString());
            dto.setUser(userDTO);
        }

        if (log.getCoffeeRecipe() != null) {
            CoffeeRecipeDTO coffeeRecipeDTO = coffeeRecipeMapper.toDTO(log.getCoffeeRecipe());
            dto.setCoffeeRecipe(coffeeRecipeDTO);
        }

        return dto;
    }
}
