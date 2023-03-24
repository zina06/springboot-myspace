package com.kosa.springbootmyspace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.springbootmyspace.domain.Category;
import com.kosa.springbootmyspace.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public int delete(int idx) {
        Optional<Category> findCategory = categoryRepository.findById(idx);
        if (!findCategory.isPresent()) {
            return 0;
        }
        categoryRepository.delete(findCategory.get());
        return 1;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int idx) {
        return categoryRepository.findById(idx).get();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public int update(Category category) {
        Optional<Category> findCategory = categoryRepository.findById(category.getIdx());
        if (!findCategory.isPresent()) {
            return 0;
        }
        categoryRepository.save(findCategory.get());
        return 1;
    }

}
