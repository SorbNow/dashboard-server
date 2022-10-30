package ru.sorb.dashboardserver.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Data
@Table
public class DashboardRecord {
    @Column
    @Id
    private UUID dashboardRecordId;

    @Column
    private String info;

    @Column
    private Long userCreatorId;
}
