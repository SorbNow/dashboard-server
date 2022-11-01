package ru.sorb.dashboardserver.service.access;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.AccessTypeEntity;
import ru.sorb.dashboardserver.exception.DashboardException;

import java.util.UUID;

@Service
public interface AccessTypeService {
    AccessTypeEntity createAccessType(AccessTypeEntity accessType);
    AccessTypeEntity getAccessType(UUID uuid) throws DashboardException;
    AccessTypeEntity updateAccessType(AccessTypeEntity accessType) throws DashboardException;
    boolean deleteAccessType(UUID uuid) throws DashboardException;
}
