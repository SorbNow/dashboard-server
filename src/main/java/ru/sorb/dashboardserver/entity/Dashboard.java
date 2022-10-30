package ru.sorb.dashboardserver.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Table
public class Dashboard {
    @Column
    @Id
    private UUID dashboardId;

    @Column
    private String dashboardName;

    @Column
    private Long userCreatorId;

    @Column
    @NotNull
    private Integer stepNumber;

}
