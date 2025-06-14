package org.example.blog.services.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.blog.domain.entities.Category;
import org.example.blog.repositories.CategoryRepository;
import org.example.blog.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findALlWithPostCounts();
    }

    @Override
    public Category createCategory(Category category) {
        if (categoryRepository.existsByNameIgnoreCase(category.getName())){
            throw new IllegalArgumentException("Category with name " + category.getName() + " already exists");
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()){
            if(!category.get().getPosts().isEmpty()){
                throw new IllegalArgumentException("Category has posts and cannot be deleted");
            }
            categoryRepository.deleteById(id);
        }
    }

    @Override
    public Category getCategoryById(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
    }
}
