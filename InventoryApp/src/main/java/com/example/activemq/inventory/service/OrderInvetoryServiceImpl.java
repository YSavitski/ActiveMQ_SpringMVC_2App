package com.example.activemq.inventory.service;

import com.example.activemq.inventory.domain.InventoryResponse;
import com.example.activemq.inventory.domain.Order;
import com.example.activemq.inventory.messaging.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderInventoryService")
public class OrderInvetoryServiceImpl implements OrderInventoryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderInvetoryServiceImpl.class);

    @Autowired
    private MessageSender messageSender;

    @Override
    public void processOrder(Order order) {
        InventoryResponse response = prepareResponse(order);
        LOGGER.info("Inventory : sending order confirmation {}", response);
        messageSender.sendMessage(response);
    }

    private InventoryResponse prepareResponse(Order order){
        InventoryResponse response = new InventoryResponse();
        response.setOrderId(order.getOrderId());
        response.setReturnCode(200);
        response.setComment("Order Processed successfully");
        return response;
    }
}
