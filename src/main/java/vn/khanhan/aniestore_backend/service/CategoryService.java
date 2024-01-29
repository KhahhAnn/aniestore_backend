package vn.khanhan.aniestore_backend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Category;

import java.util.UUID;

@Service
public interface CategoryService {
    public Category addNewCategory(Category category);

    public Category updateCategory(Category category, UUID id);

    public ResponseEntity<?> deleteCategory(UUID id);
}
