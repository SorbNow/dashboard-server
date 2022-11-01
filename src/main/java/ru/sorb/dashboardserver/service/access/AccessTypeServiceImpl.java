package ru.sorb.dashboardserver.service.access;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sorb.dashboardserver.entity.AccessTypeEntity;
import ru.sorb.dashboardserver.exception.DashboardException;
import ru.sorb.dashboardserver.repository.AccessTypeRepository;
import ru.sorb.dashboardserver.util.EntityConverter;

import java.time.LocalDateTime;
import java.util.UUID;

public class AccessTypeServiceImpl implements AccessTypeService {

    private final AccessTypeRepository accessTypeRepository;

    @Autowired
    public AccessTypeServiceImpl(AccessTypeRepository accessTypeRepository) {
        this.accessTypeRepository = accessTypeRepository;
    }

    @Override
    public AccessTypeEntity createAccessType(AccessTypeEntity accessType) {
        accessType.setUuid(null);
        accessType.setDateCreate(LocalDateTime.now());
        accessType = accessTypeRepository.save(accessType);
        return accessType;
    }

    @Override
    public AccessTypeEntity getAccessType(UUID uuid) throws DashboardException {
        if (uuid == null) {
            throw new DashboardException("id of access type can't be null");
        }
        AccessTypeEntity accessTypeEntity = accessTypeRepository.findById(uuid).orElse(null);
        if (accessTypeEntity == null) {
            throw new DashboardException("can't find access type by id");
        }
        return accessTypeEntity;

    }

    @Override
    public AccessTypeEntity updateAccessType(AccessTypeEntity accessType) throws DashboardException {
        if (accessType == null || accessType.getUuid() == null) {
            throw new DashboardException("Can't update access type. Wrong income data");
        }
        AccessTypeEntity accessTypeEntity = accessTypeRepository.findById(accessType.getUuid()).orElse(null);
        if (accessTypeEntity == null) {
            throw new DashboardException("can't find access type by id");
        }
        BeanUtils.copyProperties(accessType, accessTypeEntity);
        accessTypeEntity.setDateUpdate(LocalDateTime.now());
        accessTypeEntity = accessTypeRepository.save(accessTypeEntity);
        EntityConverter.validateRest(accessTypeEntity);
        return accessTypeEntity;
    }

    @Override
    public boolean deleteAccessType(UUID uuid) throws DashboardException {
        AccessTypeEntity accessTypeEntity = accessTypeRepository.findById(uuid).orElse(null);
        if (accessTypeEntity == null) {
            throw new DashboardException("can't find access type by id");
        }
        accessTypeEntity.setState(false);
        accessTypeRepository.save(accessTypeEntity);
        return true;
    }
}
