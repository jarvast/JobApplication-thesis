/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarvast.app.jobs.service;

import jarvast.app.jobs.entity.Category;
import jarvast.app.jobs.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author TomiPC
 */
@Service
public class CategoryService {
    
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    public Category read (String name){
        return categoryRepository.findBycategoryName(name);
    }
    public List<Category> getCategories(){
        return categoryRepository.findAll();
    }
}
