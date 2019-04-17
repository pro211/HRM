package com.nc.hrm.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LeaveType {

    SCHEDULE(0, "Có kế hoạch"),
    UNEXPECTED(0, "Đột xuất"),
    WITHOUT_PAY(0, "Không lương"),
    MARRIAGE(0, "Kết hôn"),
    FUNERAL(0, "Tang lễ");

    private int value;
    private String description;
}
