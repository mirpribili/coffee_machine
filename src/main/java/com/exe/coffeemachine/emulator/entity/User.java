package com.exe.coffeemachine.emulator.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author user
 * @year 2024
 */
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UsageLog> usageLogs;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}