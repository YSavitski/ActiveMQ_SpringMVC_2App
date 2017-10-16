package com.example.activemq.messaging;

import com.example.activemq.model.InventoryResponse;
import com.example.activemq.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class MessageReceiver {
    private final static Logger LOGGER = LoggerFactory.getLogger(MessageReceiver.class);
    private static final String ORDER_RESPONSE_QUEUE = "order-response-queue";

    @Autowired
    private OrderService orderService;

    @JmsListener(destination = ORDER_RESPONSE_QUEUE)
    public void receiveMessage(final Message<InventoryResponse> message) throws JMSException{
        LOGGER.info("+++++++++++++++++++++++++++++++++++++++++++++++++");
        MessageHeaders headers = message.getHeaders();
        LOGGER.info("Application : headers received : {}", headers);

        InventoryResponse response = message.getPayload();
        LOGGER.info("Application : response received : {}", response);

        orderService.updateOrder(response);
        LOGGER.info("+++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
