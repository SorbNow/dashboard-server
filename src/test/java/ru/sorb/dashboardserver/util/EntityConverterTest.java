package ru.sorb.dashboardserver.util;

import org.junit.jupiter.api.Test;
import ru.sorb.dashboardserver.entity.UserEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class EntityConverterTest {

    @Test
    void validateRest() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("test");
        userEntity.setPassword("password");
        userEntity.setId(UUID.randomUUID());
        EntityConverter.validateRest(userEntity);
        assertNull(userEntity.getPassword());
        assertNotNull(userEntity.getId());
        assertNotNull(userEntity.getUserName());
        assertEquals("test", userEntity.getUserName());
    }
}