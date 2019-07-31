package com.nc.hrm.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BaseEntity implements Serializable {

    @Column(name = "inserted_date", updatable = false)
    private LocalDateTime insertedDate;

    @Column(name = "inserted_by", updatable = false)
    private String insertedBy;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "updated_by")
    private String updatedBy;

    @PrePersist
    private void setInsertedMetaInfo() {
        this.insertedDate = LocalDateTime.now();
        this.insertedBy = SecurityContextHolder.getContext().getAuthentication().getName();
        this.updatedDate = LocalDateTime.now();
        this.updatedBy = SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PreUpdate
    private void setUpdatedMetaInfo() {
        this.updatedDate = LocalDateTime.now();
        this.updatedBy = SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
