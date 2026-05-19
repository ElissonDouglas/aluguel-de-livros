package com.learningspringboot.alugueldelivros.entities.enums;

public enum OrderStatus {
    REQUESTED(1),
    IN_POSSESSION(2),
    RETURNED(3),
    OVERDUE(4);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid LoanStatus code");
    }
}
