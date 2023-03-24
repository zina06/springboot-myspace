package com.kosa.springbootmyspace.service;

import java.util.Optional;

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
        Optional<CartProduct> findProduct = cartProductRepository.findById(idx);
        int result = 0;
        if (findProduct.isPresent()) {
            cartProductRepository.delete(findProduct.get());
            result = 1;
        }
        return result;
    }

    // @Override
    // public List<CartProduct> findAll(@PathVariable int idx) {
    //
    //
    // return cartProductRepository.findAll();
    // }

    @Override // xx
    public CartProduct findById(int idx) {
        return cartProductRepository.findById(idx).get();
    }

    @Override // 상품 담기
    public CartProduct save(CartProduct cartProduct) {

        return cartProductRepository.save(cartProduct);
    }

    @Override
    public int update(CartProduct cartProduct) {
        Optional<CartProduct> findCartProduct = cartProductRepository.findById(cartProduct.getIdx());
        int result = 0;
        if (findCartProduct.isPresent()) {
            CartProduct product = findCartProduct.get();
            product.setAmount(cartProduct.getAmount());
            cartProductRepository.save(product);
            result = 1;
        }
        return result;
    }

}
