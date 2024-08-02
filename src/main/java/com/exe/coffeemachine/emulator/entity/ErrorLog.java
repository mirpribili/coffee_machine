package com.exe.coffeemachine.emulator.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;
/**
 * @author user
 * @year 2024
 */
@Entity
@Data
@Table(name = "error_log")
public class ErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long errorId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true) // Указываем, что поле может быть null
    private User user;

    @Column(name = "error_message", nullable = false)
    private String errorMessage;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
