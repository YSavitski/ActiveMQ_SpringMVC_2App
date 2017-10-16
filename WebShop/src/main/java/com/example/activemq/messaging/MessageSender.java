package com.example.activemq.messaging;

import com.example.activemq.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(final Order order){
        jmsTemplate.send(session -> session.createObjectMessage(order));
    }
}
