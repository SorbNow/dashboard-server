package ru.sorb.dashboardserver.DTO;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    @Column
    @NotNull
    private String userName;

    @Column
    @NotNull
    private String password;

    @Column
    @Email(message = "e-mail field can't be null")
    private String email;
}
