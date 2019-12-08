package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Category;
import jarvast.app.jobs.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findByCategoryId(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(NoSuchElementException::new);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
