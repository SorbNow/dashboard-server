package ru.sorb.dashboardserver.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table
@Data
public class UserAccessType {
    @Column
    private UUID userId;

    @Column
    private UUID dashboardId;

    @Column
    private UUID accessTypeId;
}
