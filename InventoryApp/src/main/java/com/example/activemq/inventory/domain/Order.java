package com.example.activemq.inventory.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {
    private String orderId;

    private String productName;

    private int quantity;

    private OrderStatus status;
}
