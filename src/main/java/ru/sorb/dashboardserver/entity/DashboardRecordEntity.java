package ru.sorb.dashboardserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table
public class DashboardRecordEntity {
    @Column
    @Id
    @GeneratedValue
    private UUID dashboardRecordId;

    @Column
    private boolean state;

    @Column
    private String info;

    @Column
    private Long userCreatorId;
}
