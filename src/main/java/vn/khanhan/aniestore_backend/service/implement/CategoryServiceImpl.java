package vn.khanhan.aniestore_backend.service.implement;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.khanhan.aniestore_backend.entity.Category;
import vn.khanhan.aniestore_backend.repository.CategoryRepository;
import vn.khanhan.aniestore_backend.service.CategoryService;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    @Override
    public Category addNewCategory(Category category) {
        Category newCategory = new Category();
        newCategory.setCategoryName(category.getCategoryName());
        newCategory.setCreateAt(new Date(System.currentTimeMillis()));
        newCategory.setUpdateAt(new Date(System.currentTimeMillis()));
        newCategory.setProductsList(category.getProductsList());
        this.categoryRepository.saveAndFlush(newCategory);
        return newCategory;
    }

    @Override
    public Category updateCategory(Category category, UUID id) {
        Category updateCategory = this.categoryRepository.getReferenceById(id);
        if (updateCategory == null) {
            return null;
        }
        updateCategory.setCategoryName(category.getCategoryName());
        updateCategory.setUpdateAt(new Date(System.currentTimeMillis()));
        updateCategory.setProductsList(category.getProductsList() == null ? updateCategory.getProductsList() : category.getProductsList());
        this.categoryRepository.saveAndFlush(updateCategory);
        return updateCategory;
    }

    @Override
    public ResponseEntity<?> deleteCategory(UUID id) {
        if(!this.categoryRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Not exists!");
        }
        this.categoryRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete complete!");
    }
}
