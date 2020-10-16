package com.karamba.games.services;

import com.karamba.games.entities.Category;
import com.karamba.games.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(Category category){
        categoryRepository.save(category);}

    public void updateCategory(Category category) {
        categoryRepository.saveAndFlush(category);
    }

    public List<Category> findAllCategories(){return categoryRepository.findAll();}

    public void deleteCategoryById(Long id){
        categoryRepository.findById(id).ifPresent(productCategory -> {
            categoryRepository.delete(productCategory);
        });
    }

}
