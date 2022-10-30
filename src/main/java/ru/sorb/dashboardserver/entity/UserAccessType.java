package ru.sorb.dashboardserver.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table
@Data
public class UserAccessType {
    @Column
    @NotNull
    private UUID userId;

    @Column
    @NotNull
    private UUID dashboardId;

    @Column
    @NotNull
    private UUID accessTypeId;
}
