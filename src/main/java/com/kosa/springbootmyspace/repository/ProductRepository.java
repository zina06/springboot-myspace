package com.kosa.springbootmyspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
