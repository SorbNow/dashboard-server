package ru.sorb.dashboardserver.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import ru.sorb.dashboardserver.DTO.UserDTO;
import ru.sorb.dashboardserver.entity.UserEntity;
import ru.sorb.dashboardserver.exception.DashboardException;
import ru.sorb.dashboardserver.repository.UserRepository;
import ru.sorb.dashboardserver.util.EntityConverter;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserDTO userDTO) {
        return
                userRepository.save(EntityConverter.convertUserDTOToUser(userDTO));
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity getUser(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteUser(UUID id) throws DashboardException {
        UserEntity user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setState(false);
            userRepository.save(user);
            return true;
        } else throw new DashboardException("Can't find user");
    }

}
