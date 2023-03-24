package com.kosa.springbootmyspace.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.springbootmyspace.domain.Cart;
import com.kosa.springbootmyspace.domain.Member;
import com.kosa.springbootmyspace.repository.CartRepository;
import com.kosa.springbootmyspace.repository.MemberRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private MemberRepository memberRepository;

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

    @Override
    public Cart findByMemberOrderByIdxAsc(int memberIdx) {
        Member findMember = memberRepository.findById(memberIdx).get();
        List<Cart> cartList = cartRepository.findByMemberOrderByIdxAsc(findMember);
        return cartList.get(cartList.size() - 1);
    }

}
