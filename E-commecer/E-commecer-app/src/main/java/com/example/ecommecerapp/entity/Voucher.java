package com.example.ecommecerapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voucherId;

    @Column(nullable = false, unique = true)
    private String code;

    private Integer discount;

    private LocalDateTime validForm;
    private LocalDateTime validTo;

    @Transient
    private Status status;

    public Status getStatus(LocalDateTime now) {
        if (now.isBefore(validForm)) {
            return Status.PENDING;
        } else if (now.isAfter(validTo)) {
            return Status.EXPIRED;
        } else {
            return Status.ACTIVE;
        }
    }

    @Getter
    public enum Status {
        PENDING("Chưa kích hoạt"),
        ACTIVE("Đang hoạt động"),
        EXPIRED("Đã hết hạn");

        private final String value;

        Status(String value) {
            this.value = value;
        }
    }
}
