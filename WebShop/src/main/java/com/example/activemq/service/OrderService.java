package com.example.activemq.service;

import com.example.activemq.model.InventoryResponse;
import com.example.activemq.model.Order;

import java.util.Map;

public interface OrderService {
    public void sendOrder(Order order);

    public void updateOrder(InventoryResponse response);

    public Map<String, Order> getAllOrders();
}
