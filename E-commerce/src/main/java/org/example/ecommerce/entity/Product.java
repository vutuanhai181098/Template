package org.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false, unique = true)
    private String name;

    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Integer price;

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SUBSELECT)
//    private List<ProductImage> images = new ArrayList<>();
//
//    @Enumerated(EnumType.STRING)
//    private Status status;
//
//    @Getter
//    public enum Status {
//        NOT_YET_SOLD("Chưa mở bán"),
//        AVAILABLE("Đang bán"),
//        UNAVAILABLE("Hết hàng"),
//        CEASE("Ngừng bán");
//
//        private final String displayValue;
//
//        Status(String displayValue) {
//            this.displayValue = displayValue;
//        }
//    }
}
