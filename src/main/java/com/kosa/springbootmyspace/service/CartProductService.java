package com.kosa.springbootmyspace.service;

import com.kosa.springbootmyspace.domain.CartProduct;

public interface CartProductService {

    CartProduct save(CartProduct cartProduct);

    int update(CartProduct cartProduct);

    int delete(int idx);

    CartProduct findById(int idx);

    // List<CartProduct> findAll(int idx);

}
