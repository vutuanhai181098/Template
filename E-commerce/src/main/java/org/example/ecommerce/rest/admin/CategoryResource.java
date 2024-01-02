package org.example.ecommerce.rest.admin;

import lombok.RequiredArgsConstructor;
import org.example.ecommerce.model.request.UpsertCategory;
import org.example.ecommerce.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/admin/categories")
@RequiredArgsConstructor
public class CategoryResource {
    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<?> addCategory(@RequestBody UpsertCategory request) {
        return ResponseEntity.ok(categoryService.addCategory(request));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody UpsertCategory request) {
        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
        return ResponseEntity.ok().body("Xoá thành công");
    }
}
