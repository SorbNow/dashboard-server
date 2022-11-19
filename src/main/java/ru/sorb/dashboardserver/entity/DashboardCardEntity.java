package ru.sorb.dashboardserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table
public class DashboardCardEntity {

    @Id
    @GeneratedValue
    private UUID cardId;

    @Column
    private String name;

    @Column
    private Boolean state;

    @Column(updatable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateCreate;

    @Column
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateUpdate;

    @ManyToOne
    @JoinColumn(name = "dashboard_id", nullable = false)
    @JsonIgnoreProperties(value = "dashboardCardEntities")
    @JsonBackReference
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private DashboardEntity dashboardEntity;

    @OneToMany(mappedBy = "dashboardCardEntity")
    @JsonProperty(namespace = "dashboardRecordEntities", access = JsonProperty.Access.READ_ONLY)
    private List<DashboardRecordEntity> dashboardRecordEntities;

    @ManyToOne
    @JoinColumn(name = "creator_id", updatable = false)
    @JsonProperty(namespace = "creatorUser" , access = JsonProperty.Access.READ_ONLY)
    private UserEntity creatorUser;

    @ManyToOne
    @JoinColumn(name = "updater_user_id")
    @JsonProperty(namespace = "updaterUser", access = JsonProperty.Access.READ_ONLY)
    private UserEntity updaterUser;
}
