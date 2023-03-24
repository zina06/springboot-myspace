package com.kosa.springbootmyspace.service;

import com.kosa.springbootmyspace.domain.Order;
import com.kosa.springbootmyspace.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order order){
        return orderRepository.save(order);
    }

    @Override
    public Order findByID(int idx) {
        return orderRepository.findById(idx).get();
    }

    @Override
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @Override
    public int delete(int idx) {
        Optional<Order> findOrder = orderRepository.findById(idx);
        int result=0;
        if(findOrder.isPresent()){
            orderRepository.delete(findOrder.get());
            result=1;
        }
        return result;
    }


}
