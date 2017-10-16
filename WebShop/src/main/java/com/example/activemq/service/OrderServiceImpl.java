package com.example.activemq.service;

import com.example.activemq.messaging.MessageSender;
import com.example.activemq.model.InventoryResponse;
import com.example.activemq.model.Order;
import com.example.activemq.model.OrderStatus;
import com.example.activemq.util.BasicUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MessageSender messageSender;


    @Override
    public void sendOrder(Order order) {
        LOGGER.info("+++++++++++++++++++++++++++++++++++++++++++++++++");
        order.setOrderId(BasicUtil.getUniqueID());
        order.setStatus(OrderStatus.CREATED);
        orderRepository.putOrder(order);
        LOGGER.info("Application : sending order request {}", order);
        messageSender.sendMessage(order);
        LOGGER.info("+++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @Override
    public void updateOrder(InventoryResponse response) {
        Order order = orderRepository.getOrder(response.getOrderId());
        if(response.getReturnCode()==200){
            order.setStatus(OrderStatus.CONFIRMED);
        } else if(response.getReturnCode()==300){
            order.setStatus(OrderStatus.FAILED);
        } else {
            order.setStatus(OrderStatus.PENDING);
        }
        orderRepository.putOrder(order);
    }

    @Override
    public Map<String, Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
}
