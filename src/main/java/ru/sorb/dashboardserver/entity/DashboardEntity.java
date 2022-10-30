package ru.sorb.dashboardserver.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Table
public class DashboardEntity {
    @Column
    @Id
    @GeneratedValue
    private UUID dashboardId;

    @Column
    private boolean state;

    @Column
    private String dashboardName;

    @Column
    private Long userCreatorId;

    @Column
    @NotNull
    private Integer stepNumber;

}
