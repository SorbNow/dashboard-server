package ru.sorb.dashboardserver.DTO;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class UserDTO {

//    private UUID uuid;

    @NotNull
    private String userName;

    @NotNull
    private String password;

    @Email(message = "e-mail field can't be null")
    private String email;
}
