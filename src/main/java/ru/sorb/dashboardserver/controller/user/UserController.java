package ru.sorb.dashboardserver.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sorb.dashboardserver.DTO.UserDTO;
import ru.sorb.dashboardserver.entity.UserEntity;
import ru.sorb.dashboardserver.exception.DashboardException;
import ru.sorb.dashboardserver.service.user.UserService;

import javax.validation.Valid;
import java.util.UUID;

@RestController("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/list")
    public String listUser(){
        return "welcome";
    }

    @GetMapping("/{userId}")
    public UserEntity getUser(@PathVariable UUID userId) throws DashboardException {
        return userService.getUser(userId);
    }

    @PostMapping("/create")
    public UserEntity createUser(@Valid @RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }
}
