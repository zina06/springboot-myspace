package com.kosa.springbootmyspace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.springbootmyspace.domain.Cart;
import com.kosa.springbootmyspace.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public int delete(int idx) {
        Optional<Cart> findCart = cartRepository.findById(idx);
        int result = 0;
        if (findCart.isPresent()) {
            cartRepository.delete(findCart.get());
            result = 1;
        }
        return result;
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(int idx) {
        return cartRepository.findById(idx).get();
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

}
