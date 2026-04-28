package com.learningspringboot.alugueldelivros.entities.enums;

public enum LoanStatus {
    REQUESTED(1),
    IN_POSSESSION(2),
    RETURNED(3),
    OVERDUE(4);

    private int code;

    private LoanStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static LoanStatus valueOf(int code) {
        for (LoanStatus value : LoanStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid LoanStatus code");
    }
}
