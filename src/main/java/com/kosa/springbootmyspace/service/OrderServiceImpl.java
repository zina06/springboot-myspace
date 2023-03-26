package com.kosa.springbootmyspace.service;

import com.kosa.springbootmyspace.domain.Cart;
import com.kosa.springbootmyspace.domain.Member;
import com.kosa.springbootmyspace.domain.Order;
import com.kosa.springbootmyspace.repository.CartRepository;
import com.kosa.springbootmyspace.repository.MemberRepository;
import com.kosa.springbootmyspace.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Order save(Order order) {
        Order saveOrder = orderRepository.save(order);
        if (saveOrder != null) {
            Cart cart = new Cart();
            cart.setMember(memberRepository.findById(order.getMember().getIdx()).get());
            cartRepository.save(cart);
        }
        return saveOrder;
    }

    @Override
    public List<Order> findAllByMemberIdx(int idx) {
        Optional<Member> findMember = memberRepository.findById(idx);
        if (findMember.isPresent()) {
            return orderRepository.findByMemberOrderByIdxDesc(findMember.get());
        }
        return null;
    }

    @Override
    public Order findByID(int idx) {
        return orderRepository.findById(idx).get();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public int delete(int idx) {
        Optional<Order> findOrder = orderRepository.findById(idx);
        int result = 0;
        if (findOrder.isPresent()) {
            orderRepository.delete(findOrder.get());
            result = 1;
        }
        return result;
    }

}
