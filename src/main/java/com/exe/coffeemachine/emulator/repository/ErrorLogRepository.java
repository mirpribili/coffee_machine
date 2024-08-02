package com.exe.coffeemachine.emulator.repository;

import com.exe.coffeemachine.emulator.entity.ErrorLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 * @year 2024
 */
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
}
