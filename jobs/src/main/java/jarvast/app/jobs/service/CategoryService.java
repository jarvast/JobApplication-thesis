package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Category;
import jarvast.app.jobs.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findByCategoryId(Long categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
