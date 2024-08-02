package com.exe.coffeemachine.emulator.repository;

import com.exe.coffeemachine.emulator.entity.UsageLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 * @year 2024
 */
public interface UsageLogRepository extends JpaRepository<UsageLog, Long> {
}
