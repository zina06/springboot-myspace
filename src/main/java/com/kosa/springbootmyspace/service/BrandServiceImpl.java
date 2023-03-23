package com.kosa.springbootmyspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.springbootmyspace.domain.Brand;
import com.kosa.springbootmyspace.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public int delete(int idx) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Brand> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Brand findById(int idx) {
        return brandRepository.findById(idx).get();
    }

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public int update(Brand brand) {
        // TODO Auto-generated method stub
        return 0;
    }

}
