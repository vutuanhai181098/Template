package org.example.ecommerce.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.ecommerce.entity.Category;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CategoryDto {
    String name;

    String slug;

    Category parentCategory;

    List<Category> subCategory;
}
