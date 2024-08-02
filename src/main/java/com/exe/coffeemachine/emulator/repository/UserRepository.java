package com.exe.coffeemachine.emulator.repository;

import com.exe.coffeemachine.emulator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author user
 * @year 2024
 */
public interface UserRepository extends JpaRepository<User, Long> {
}