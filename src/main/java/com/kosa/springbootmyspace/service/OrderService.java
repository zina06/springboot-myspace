package com.kosa.springbootmyspace.service;

import com.kosa.springbootmyspace.domain.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);

    int delete(int idx);

    Order findByID(int idx);

    List<Order> findAll();
}
