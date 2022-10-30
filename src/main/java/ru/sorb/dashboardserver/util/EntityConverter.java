package ru.sorb.dashboardserver.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.sorb.dashboardserver.DTO.UserDTO;
import ru.sorb.dashboardserver.entity.UserEntity;

public class EntityConverter {
    public static UserEntity convertUserDTOToUser(UserDTO dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserEntity userEntity = new UserEntity();
        userEntity.setState(true);
        userEntity.setId(null);
        userEntity.setUserName(dto.getUserName());
        userEntity.setPassword(encoder.encode(dto.getPassword()));
        userEntity.setEmail(dto.getEmail());
        return userEntity;
    }
}
