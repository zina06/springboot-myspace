package com.kosa.springbootmyspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Cart;
import com.kosa.springbootmyspace.domain.Member;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByMemberOrderByIdxAsc(Member member);//카트에서 멤버아이디로 검색
    //멤버아이디를 가진 카트를 검색 -> 카트 idz가 가장 높은 값을 가져옴
}
