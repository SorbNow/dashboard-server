package ru.sorb.dashboardserver.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Data
public class AccessTypeEntity {
    @Column
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column
    private boolean state;

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

    @Column
    private LocalDateTime dateCreate;

    @Column
    private LocalDateTime dateUpdate;

    @Column
    private UUID creatorId;

}
