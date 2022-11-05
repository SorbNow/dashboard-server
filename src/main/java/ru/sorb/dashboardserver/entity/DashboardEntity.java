package ru.sorb.dashboardserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table
public class DashboardEntity {
    @Column(columnDefinition = "uuid")
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

    @Column
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateCreate;

    @Column
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateUpdate;

    @OneToMany(mappedBy = "dashboardEntity")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<DashboardRecordEntity> dashboardRecords;

    @OneToMany
    @JoinColumn(name = "creator_id", updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserEntity creatorUser;

    @OneToMany
    @JoinColumn(name = "updater_user_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserEntity updaterUser;

}
