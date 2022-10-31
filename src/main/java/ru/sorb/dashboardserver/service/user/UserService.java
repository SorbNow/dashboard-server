package ru.sorb.dashboardserver.service.user;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.DTO.UserDTO;
import ru.sorb.dashboardserver.entity.UserEntity;
import ru.sorb.dashboardserver.exception.DashboardException;

import java.util.UUID;

@Service
public interface UserService {
    UserEntity createUser(UserEntity userEntity);
    UserEntity updateUser(UserEntity user) throws DashboardException;
    UserEntity getUser(UUID id) throws DashboardException;
    boolean deleteUser(UUID id) throws DashboardException;
}
