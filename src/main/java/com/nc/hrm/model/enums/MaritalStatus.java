package com.nc.hrm.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum MaritalStatus {

    SINGLE(0, "Độc thân"),
    MARRIED(1, "Đã kết hôn"),
    COMPLICATED(2, "Phức tạp"),
    OTHER(3, "Khác");

    private int value;
    private String description;

    public static String textOf(int value) {
        return MaritalStatus.values()[value].description;
    }
}
