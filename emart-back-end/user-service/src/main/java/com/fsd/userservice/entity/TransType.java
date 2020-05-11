package com.fsd.userservice.entity;


public enum TransType {
    DEBIT("debit"),
    CREDIT("credit");

    private String type;

    TransType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
