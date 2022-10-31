package ru.sorb.dashboardserver.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sorb.dashboardserver.DTO.UserDTO;
import ru.sorb.dashboardserver.entity.UserEntity;
import ru.sorb.dashboardserver.exception.DashboardException;
import ru.sorb.dashboardserver.repository.UserRepository;
import ru.sorb.dashboardserver.util.EntityConverter;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setDateCreate(LocalDateTime.now());
        EntityConverter.validateRest(userRepository.save(userEntity));
        return userEntity;
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) throws DashboardException {
        if (userEntity == null || userEntity.getId() == null) {
            throw new DashboardException("Wrong user entity for creating");
        }
        UserEntity user= userRepository.findById(userEntity.getId()).orElse(null);
        if (user == null) {
            throw new DashboardException("Can't find user by id");
        }
        userEntity.setLastChangeDate(LocalDateTime.now());
        userEntity = userRepository.save(userEntity);
        EntityConverter.validateRest(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity getUser(UUID id) throws DashboardException {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity == null) {
            throw new DashboardException("Can't find user by id");
        }
        EntityConverter.validateRest(userEntity);
        return userEntity;
    }

    @Override
    public boolean deleteUser(UUID id) throws DashboardException {
        UserEntity user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setState(false);
            userRepository.save(user);
            return true;
        } else throw new DashboardException("Can't find user by id");
    }

}
