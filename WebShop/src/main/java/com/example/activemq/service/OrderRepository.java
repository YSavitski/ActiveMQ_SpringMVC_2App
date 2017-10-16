package com.example.activemq.service;

import com.example.activemq.model.Order;

import java.util.Map;

public interface OrderRepository {
    public void putOrder(Order order);

    public Order getOrder(String orderId);

    public Map<String, Order> getAllOrders();
}
