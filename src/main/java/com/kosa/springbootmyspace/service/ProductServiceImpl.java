package com.kosa.springbootmyspace.service;

import java.util.List;

import com.kosa.springbootmyspace.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.springbootmyspace.domain.Product;
import com.kosa.springbootmyspace.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public int delete(int idx) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product findById(int idx) {
        return productRepository.findById(idx).get();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public int update(Product product) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findByNameLike(String searchKeyword) {
        return productRepository.findByNameLike(searchKeyword);
    }
}
