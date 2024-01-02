package org.example.ecommerce.mapper.impl;

import com.github.slugify.Slugify;
import lombok.RequiredArgsConstructor;
import org.example.ecommerce.entity.Category;
import org.example.ecommerce.mapper.CategoryMapper;
import org.example.ecommerce.model.dto.CategoryDto;
import org.example.ecommerce.model.request.UpsertCategory;
import org.example.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.lang.module.ResolutionException;

@Component
@RequiredArgsConstructor
public class CategoryMapperImpl implements CategoryMapper {

    private final CategoryRepository categoryRepository;
    private final Slugify slugify;
    @Override
    public Category mapToEntity(UpsertCategory resquest) {
        Category category = new Category();
        category.setName(resquest.getName());
        category.setSlug(slugify.slugify(resquest.getName()));
        if (resquest.getParentCategoryId() != null) {
            Category parentCategory = categoryRepository.findById(resquest.getParentCategoryId())
                    .orElseThrow(() -> new ResolutionException("Cannot found category with Id " + resquest.getParentCategoryId()));
            category.setParentCategory(parentCategory);
        }
        return category;
    }

    @Override
    public CategoryDto mapToDto(Category category) {
        return CategoryDto.builder()
                .name(category.getName())
                .slug(category.getSlug())
                .parentCategory(category.getParentCategory())
                .subCategory(category.getSubCategories())
                .build();
    }
}
