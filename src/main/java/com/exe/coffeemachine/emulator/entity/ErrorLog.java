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
    @JoinColumn(name = "user_id")
    private User user;

    private String errorMessage;
    private LocalDateTime createdAt;
}
