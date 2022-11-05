package ru.sorb.dashboardserver.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table
@Data
public class UserAccessTypeEntity {

    @Column(columnDefinition = "uuid")
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column
    private boolean state;

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
