package ru.sorb.dashboardserver.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Column
    @Id
    private Long id;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String comment;

}
