package ru.sorb.dashboardserver.service.user;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.UserEntity;
import ru.sorb.dashboardserver.exception.DashboardException;

import java.util.UUID;

@Service
public interface UserService {
    UserEntity createUser(UserEntity user);
    UserEntity updateUser(UserEntity user);
    UserEntity getUser(UUID id);
    boolean deleteUser(UUID id) throws DashboardException;
}
