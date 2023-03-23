package com.kosa.springbootmyspace.service;

import java.util.List;

import com.kosa.springbootmyspace.domain.Product;

public interface ProductService {

    Product save(Product product);

    int update(Product product);

    int delete(int idx);

    Product findById(int idx);

    List<Product> findAll();
}
