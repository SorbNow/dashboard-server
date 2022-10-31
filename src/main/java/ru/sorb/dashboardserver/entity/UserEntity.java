package ru.sorb.dashboardserver.entity;

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
    @Column
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private boolean state;

    @Column
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
    private LocalDateTime dateCreate;

    @Column
    private LocalDateTime lastChangeDate;

    @Column
    private UUID lastUserChangedId;

}
