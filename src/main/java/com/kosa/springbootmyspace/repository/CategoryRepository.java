package com.kosa.springbootmyspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
