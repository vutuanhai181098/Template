package org.example.ecommerce.mapper;

import org.example.ecommerce.entity.Category;
import org.example.ecommerce.model.dto.CategoryDto;
import org.example.ecommerce.model.request.UpsertCategory;

public interface CategoryMapper {
    Category mapToEntity(UpsertCategory resquest);

    CategoryDto mapToDto(Category category);
}
