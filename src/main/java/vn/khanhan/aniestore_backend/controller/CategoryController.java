package vn.khanhan.aniestore_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khanhan.aniestore_backend.entity.Category;
import vn.khanhan.aniestore_backend.service.CategoryService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        Category response = this.categoryService.addNewCategory(category);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable UUID id) {
        Category response = this.categoryService.updateCategory(category, id);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable UUID id) {
        ResponseEntity<?> response = this.categoryService.deleteCategory(id);
        return response;
    }
}
