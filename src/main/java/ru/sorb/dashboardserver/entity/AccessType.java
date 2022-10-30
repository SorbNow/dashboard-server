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
public class AccessType {
    @Column
    private UUID uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @NotNull
    private Boolean createAccess;

    @Column(nullable = false)
    @NotNull
    private Boolean readAccess;

    @Column(nullable = false)
    @NotNull
    private Boolean writeAccess;

    @Column(nullable = false)
    @NotNull
    private Boolean deleteAccess;

    @Column(nullable = false)
    @NotNull
    private Boolean canGrantAccess;

}
