package com.exe.coffeemachine.emulator.controller;

import com.exe.coffeemachine.emulator.dto.UsageLogDTO;
import com.exe.coffeemachine.emulator.entity.UsageLog;
import com.exe.coffeemachine.emulator.mapper.UsageLogMapper;
import com.exe.coffeemachine.emulator.repository.UsageLogRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для управления логами использования
 * @author user
 * @year 2024
 */
@RestController
@RequestMapping("/api/logs")
@Tag(name = "Логи использования", description = "API для получения логов использования кофе-машины")
public class LogController {

    @Autowired
    private UsageLogRepository usageLogRepository;

    @Autowired
    private UsageLogMapper usageLogMapper;

    @GetMapping
    @Operation(summary = "Получить все логи", description = "Возвращает список всех логов использования кофе-машины")
    @ApiResponse(responseCode = "200", description = "Логи успешно возвращены")
    public List<UsageLogDTO> getAllLogs() {
        List<UsageLog> logs = usageLogRepository.findAll();
        return logs.stream().map(usageLogMapper::toDTO).collect(Collectors.toList());
    }
}
