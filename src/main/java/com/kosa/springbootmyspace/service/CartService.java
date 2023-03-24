package com.kosa.springbootmyspace.service;

import java.util.List;

import com.kosa.springbootmyspace.domain.Cart;

public interface CartService {

    Cart save(Cart cart);

    int delete(int idx);

    Cart findById(int idx);

    List<Cart> findAll();

    Cart findByMemberOrderByIdxAsc(int memberIdx);

}
