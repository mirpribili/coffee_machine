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

    @Column(nullable = false, length = 100) // Указываем, что поле не может быть null и задаем максимальную длину
    private String username;

    @Column(nullable = false, length = 100) // Указываем, что поле не может быть null и задаем максимальную длину
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UsageLog> usageLogs;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
