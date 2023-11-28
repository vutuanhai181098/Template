package com.example.ecommecerapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String username;

    @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(15)")
    private String phone;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, USER
    }

    private Boolean enabled;

    private Boolean locked;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;
}
