package ru.sorb.dashboardserver.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.sorb.dashboardserver.entity.UserEntity;
import ru.sorb.dashboardserver.service.user.UserService;

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

    @GetMapping("/{userid}")
    public UserEntity getUser(@PathVariable UUID userid){
        return userService.getUser(userid);
    }
}
