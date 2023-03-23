package com.kosa.springbootmyspace.service;

import java.util.List;

import com.kosa.springbootmyspace.domain.Brand;

public interface BrandService {

    Brand save(Brand brand);

    int update(Brand brand);

    int delete(int idx);

    Brand findById(int idx);

    List<Brand> findAll();
}
