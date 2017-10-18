package com.example.activemq.inventory.messaging;

import com.example.activemq.inventory.domain.InventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component()
public class MessageSender {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(final InventoryResponse inventoryResponse){
        jmsTemplate.send(session -> session.createObjectMessage(inventoryResponse));
    }
}
