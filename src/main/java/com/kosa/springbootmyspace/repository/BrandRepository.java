package com.kosa.springbootmyspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
