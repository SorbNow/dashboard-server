package ru.sorb.dashboardserver.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Table
public class User {
    @Column
    @Id
    private UUID id;

    @Column
    @NotNull
    private String userName;

    @Column
    @NotNull
    private String password;

    @Column
    private String comment;

    @Column
    @Email
    private String email;

}
