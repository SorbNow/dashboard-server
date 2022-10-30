package ru.sorb.dashboardserver.service.access;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.AccessType;

import java.util.UUID;

@Service
public interface AccessTypeService {
    AccessType createAccessType(AccessType accessType);
    AccessType getAccessType(UUID uuid);
    AccessType updateAccessType(AccessType accessType);
    boolean deleteAccessType(UUID uuid);
}
