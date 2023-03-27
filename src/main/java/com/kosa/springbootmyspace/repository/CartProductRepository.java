package com.kosa.springbootmyspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Cart;
import com.kosa.springbootmyspace.domain.CartProduct;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {

    List<CartProduct> findByCart(Cart cart);

}
