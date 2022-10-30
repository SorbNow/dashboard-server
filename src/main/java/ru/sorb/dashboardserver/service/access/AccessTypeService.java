package ru.sorb.dashboardserver.service.access;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.AccessTypeEntity;

import java.util.UUID;

@Service
public interface AccessTypeService {
    AccessTypeEntity createAccessType(AccessTypeEntity accessType);
    AccessTypeEntity getAccessType(UUID uuid);
    AccessTypeEntity updateAccessType(AccessTypeEntity accessType);
    boolean deleteAccessType(UUID uuid);
}
