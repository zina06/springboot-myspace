package com.kosa.springbootmyspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Cart;
import com.kosa.springbootmyspace.domain.Member;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByMemberOrderByIdxAsc(Member member);
}
