package com.example.ecommecerapp.entity;

import com.example.ecommecerapp.model.enums.TypeProduct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_size")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productSizeId;

    private String name;

    private Integer minHeight;
    private Integer maxHeight;
    private Integer minWeight;
    private Integer maxWeight;

    @Enumerated(EnumType.STRING)
    private TypeProduct typeProduct;

    @Getter
    public enum Unit {
        WEIGHT("kg"), HEIGHT("cm");
        private final String value;
        Unit(String value) {
            this.value = value;
        }
    }
}
