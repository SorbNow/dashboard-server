package ru.sorb.dashboardserver.service.user;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.UserEntity;
import ru.sorb.dashboardserver.exception.DashboardException;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    UserEntity createUser(UserEntity userEntity);

    UserEntity updateUser(UserEntity user) throws DashboardException;

    UserEntity getUser(UUID id) throws DashboardException;

    boolean deleteUser(UUID id) throws DashboardException;

    List<UserEntity> listUser(boolean isBlocked, boolean isDeleted, String username, boolean isLikeUsername, String email, boolean isLikeEmail, String fullName, boolean isLikeFullName, String fieldForOrder, boolean isAsc);
}
