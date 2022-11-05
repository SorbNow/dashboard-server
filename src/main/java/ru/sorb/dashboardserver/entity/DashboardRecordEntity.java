package ru.sorb.dashboardserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table
public class DashboardRecordEntity {
    @Column(columnDefinition = "uuid")
    @Id
    @GeneratedValue
    private UUID dashboardRecordId;

    @Column
    private boolean state;

    @Column
    private String info;
/*
    @Column(updatable = false)
    private Long userCreatorId;*/

    /*@Column(nullable = false, name = "dash")
    @NotNull
    private UUID dashboardId;*/

    @Column(updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateCreate;

    @Column
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateUpdate;
/*
    @Column
    private UUID userUpdatedId;
*/

    @ManyToOne
    @JoinColumn(name = "dashboard_id", nullable = false)
    @JsonIgnoreProperties(value = "dashboardRecords")
    @JsonBackReference
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private DashboardEntity dashboardEntity;

    @ManyToOne
    @JoinColumn(name = "creator_id", updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserEntity creatorUser;

    @ManyToOne
    @JoinColumn(name = "updater_user_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserEntity updaterUser;

}
