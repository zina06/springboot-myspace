package com.kosa.springbootmyspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kosa.springbootmyspace.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
