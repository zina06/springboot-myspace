package com.kosa.springbootmyspace.service;

import java.util.List;

import com.kosa.springbootmyspace.domain.Category;

public interface CategoryService {

    Category save(Category category);

    int update(Category category);

    int delete(int idx);

    Category findById(int idx);

    List<Category> findAll();
}
