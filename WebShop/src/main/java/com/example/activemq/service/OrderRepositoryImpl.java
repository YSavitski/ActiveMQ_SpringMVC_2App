package com.example.activemq.service;

import com.example.activemq.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Repository("orderRepository")
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void putOrder(Order order) {

    }

    @Override
    public Order getOrder(String orderId) {
        return null;
    }

    @Override
    public Map<String, Order> getAllOrders() {
        return null;
    }
}
