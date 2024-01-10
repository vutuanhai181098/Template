package org.example.ecommerce.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.entity.Category;
import org.example.ecommerce.exception.BadRequestException;
import org.example.ecommerce.mapper.CategoryMapper;
import org.example.ecommerce.model.dto.CategoryDto;
import org.example.ecommerce.model.request.UpsertCategory;
import org.example.ecommerce.repository.CategoryRepository;
import org.example.ecommerce.service.CategoryService;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto addCategory(UpsertCategory request) {
        Category category = categoryMapper.mapToEntity(request);
        categoryRepository.save(category);
        return categoryMapper.mapToDto(category);
    }

    @Override
    public CategoryDto updateCategory(Long id, UpsertCategory request) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResolutionException("Can not found category with Id " + id));

//        if (category.getParentCategory() != null) {
//            // check category has product use it. if it has, cannot delete. if not, delete
//            if (!category.getProducts().isEmpty()) {
//                throw new BadRequestException("This category cannot be deleted because it currently has applicable products");
//            } else {
//                categoryRepository.delete(category);
//            }
//        } else {
//            List<Category> subCategories = category.getSubCategories();
//            for (Category subCategory : subCategories) {
//                if (!subCategory.getProducts().isEmpty()) {
//                    throw new BadRequestException("Không thể xoá category này vì có sản phẩm đang sử dụng");
//                }
//            }
//            // delete category parent and sub category
//            categoryRepository.delete(category);
//        }
    }
}
