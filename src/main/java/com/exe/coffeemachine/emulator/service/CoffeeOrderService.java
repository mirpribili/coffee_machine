package com.exe.coffeemachine.emulator.service;

import com.exe.coffeemachine.emulator.dto.OrderDTO;
import com.exe.coffeemachine.emulator.entity.UsageLog;
/**
 * @author user
 * @year 2024
 */
public interface CoffeeOrderService {
    UsageLog placeOrder(OrderDTO orderDTO) throws Exception;
}
