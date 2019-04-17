package com.nc.hrm.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LeaveRequestStatus {

    REJECTED(0, "Từ chối"),
    CANCELLED(1, "Hủy bỏ"),
    PENDING_APPROVAL(2, "Chờ xác nhận"),
    SCHEDULED(3, "Đã lên kế hoạch"),
    TAKEN(4, "Đã nghỉ");

    private int value;
    private String description;

}
