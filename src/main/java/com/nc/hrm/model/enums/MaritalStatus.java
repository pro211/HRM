package com.nc.hrm.model.enums;

import lombok.Getter;

@Getter
public enum MaritalStatus {

    SINGLE(0, "Độc thân"),
    MARRIED(1, "Đã kết hôn"),
    DIVORCED(2, "Đã ly dị"),
    OTHER(3, "Khác");

    private int value;
    private String text;

    MaritalStatus(int value, String text) {
        this.value = value;
        this.text = text;
    }
}
