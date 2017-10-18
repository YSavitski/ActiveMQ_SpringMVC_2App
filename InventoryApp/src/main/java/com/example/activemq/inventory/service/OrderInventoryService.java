package com.example.activemq.inventory.service;

import com.example.activemq.inventory.domain.Order;

public interface OrderInventoryService {
    public void processOrder(Order order);
}
