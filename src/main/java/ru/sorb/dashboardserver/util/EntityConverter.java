package ru.sorb.dashboardserver.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.sorb.dashboardserver.DTO.UserDTO;
import ru.sorb.dashboardserver.entity.UserEntity;
import ru.sorb.dashboardserver.util.annotations.NotShowInRest;

import java.lang.reflect.Field;
import java.util.Arrays;

public class EntityConverter {
    private static  final Logger logger  = LoggerFactory.getLogger(EntityConverter.class);
    public static UserEntity convertUserDTOToUser(UserDTO dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserEntity userEntity = new UserEntity();
        userEntity.setState(true);
//        userEntity.setId(dto.getUuid());
        userEntity.setUserName(dto.getUserName());
        userEntity.setPassword(encoder.encode(dto.getPassword()));
        userEntity.setEmail(dto.getEmail());
        return userEntity;
    }

    public static UserDTO convertUserToDTO(UserEntity userEntity) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserDTO userDTO = new UserDTO();
//        userDTO.setUuid(userEntity.getId());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setEmail(userEntity.getEmail());
        return userDTO;
    }

    public static void copyProperties(UserDTO dto, UserEntity userEntity) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        userEntity.setState(userEntity.getState());
//        userEntity.setId(dto.getUuid());
        userEntity.setUserName(dto.getUserName());
        userEntity.setEmail(dto.getEmail());
//        return userEntity;
    }

    public static void validateRest(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            if (field.isAnnotationPresent(NotShowInRest.class)) {
                if (!field.getType().isPrimitive()) {
                    field.setAccessible(true);
                    try {
                        field.set(obj, null);
                    } catch (IllegalAccessException e) {
                        logger.error(e.getMessage());
                    }
                }
            }
        });
    }

}
