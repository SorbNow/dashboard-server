package ru.sorb.dashboardserver.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
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

    @Column(updatable = false)
    private Long userCreatorId;

    @Column(nullable = false)
    @NotNull
    private UUID dashboardId;

    @Column(updatable = false)
    private LocalDateTime dateCreate;

    @Column
    private LocalDateTime dateUpdate;

    @Column
    private UUID userUpdatedId;
}
