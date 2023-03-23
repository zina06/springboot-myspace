package com.kosa.springbootmyspace.service;

import java.util.List;

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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Category> findAll() {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
        return 0;
    }

}
