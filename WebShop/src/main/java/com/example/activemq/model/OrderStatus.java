package com.example.activemq.model;

public enum OrderStatus {
    CREATED("Created"),
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    FAILED("Failed");

    private String status;

    private OrderStatus(final String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "status='" + this.status + '\'' +
                '}';
    }

    public String getName(){
        return this.name();
    }
}
