package org.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "token_confirm")
public class TokenConfirm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate createdDate;
    private LocalDate confirmedDate;
    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType;

    public enum TokenType {
        EMAIL_VERIFICATION,
        PASSWORD_RESET
    }

    @PrePersist
    void prePersist(){
        createdDate = LocalDate.now();
    }
}
