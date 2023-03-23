package com.kosa.springbootmyspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.springbootmyspace.domain.CartProduct;
import com.kosa.springbootmyspace.repository.CartProductRepository;

@Service
public class CartProductServiceImpl implements CartProductService {

    @Autowired
    private CartProductRepository cartProductRepository;

    @Override
    public int delete(int idx) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<CartProduct> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CartProduct findById(int idx) {
        return cartProductRepository.findById(idx).get();
    }

    @Override
    public CartProduct save(CartProduct cartProduct) {
        return cartProductRepository.save(cartProduct);
    }

    @Override
    public int update(CartProduct cartProduct) {
        // TODO Auto-generated method stub
        return 0;
    }

}
