package com.kosa.springbootmyspace.repository;

import com.kosa.springbootmyspace.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(Category category);

    List<Product> findByNameLike(String searchKeyword);

}
