package ru.sorb.dashboardserver.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.sorb.dashboardserver.util.annotations.NotShowInRest;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "principal")
public class UserEntity {
    @Column(columnDefinition = "uuid")
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private boolean state;

    @Column(name = "is_blocked")
    private Boolean isBlocked;

    @Column(name = "username")
    @NotNull
    private String userName;

    @Column
    @NotNull
    @NotShowInRest
    private String password;

    @Column
    private String comment;

    @Column
    @Email(message = "e-mail field can't be null")
    private String email;

    @Column
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateCreate;

    @Column
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime lastChangeDate;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserEntity creatorUser;

    @ManyToOne
    @JoinColumn(name = "updater_id")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserEntity updaterUser;

}
