package com.example.activemq.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class InventoryResponse implements Serializable {
    private String orderId;
    private int returnCode;
    private String comment;
}
