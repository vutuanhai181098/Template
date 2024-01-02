package org.example.ecommerce.service;

import org.example.ecommerce.model.dto.CategoryDto;
import org.example.ecommerce.model.request.UpsertCategory;

public interface CategoryService {

    CategoryDto addCategory(UpsertCategory request);

    CategoryDto updateCategory(Long id, UpsertCategory request);
    void deleteById(Long id);
}
