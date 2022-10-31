package ru.sorb.dashboardserver.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sorb.dashboardserver.entity.UserEntity;
import ru.sorb.dashboardserver.exception.DashboardException;
import ru.sorb.dashboardserver.service.user.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<UserEntity> listUser(
            @RequestParam(required = false, defaultValue = "false") boolean isBlocked,
            @RequestParam(required = false, defaultValue = "false") boolean isDeleted,
            @RequestParam(required = false) String username,
            @RequestParam(required = false, defaultValue = "true") boolean isLikeUsername,
            @RequestParam(required = false) String email,
            @RequestParam(required = false, defaultValue = "true") boolean isLikeEmail,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false, defaultValue = "true") boolean isLikeFullName,
            @RequestParam(required = false, defaultValue = "id") String fieldForOrder,
            @RequestParam(required = false, defaultValue = "true") boolean isAsc


    ) {
        return userService.listUser(isBlocked, isDeleted,
                username, isLikeUsername,
                email, isLikeEmail,
                fullName, isLikeFullName,
                fieldForOrder, isAsc);
    }

    @GetMapping("/{userId}")
    public UserEntity getUser(@PathVariable UUID userId) throws DashboardException {
        return userService.getUser(userId);
    }

    @PostMapping("/create")
    public UserEntity createUser(@Valid @RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);
    }

    @PostMapping()
    public UserEntity updateUser(@Valid @RequestBody UserEntity userEntity) throws DashboardException {
        return userService.updateUser(userEntity);
    }

    @DeleteMapping("/delete/{userId}")
    public boolean deleteUser(@PathVariable UUID userId) throws DashboardException {
        return userService.deleteUser(userId);
    }
}
