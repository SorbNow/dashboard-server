package ru.sorb.dashboardserver.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Table(name = "client")
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
    private String password;

    @Column
    private String comment;

    @Column
    @Email(message = "e-mail field can't be null")
    private String email;

}
