package ru.sorb.dashboardserver.service.dashboard;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.DashboardEntity;
import ru.sorb.dashboardserver.exception.DashboardException;
import ru.sorb.dashboardserver.repository.DashboardRecordRepository;
import ru.sorb.dashboardserver.repository.DashboardRepository;
import ru.sorb.dashboardserver.util.EntityConverter;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final DashboardRepository dashboardRepository;

    @Autowired
    public DashboardServiceImpl(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    @Override
    public DashboardEntity createDashboard(DashboardEntity dashboard) throws DashboardException {
        if (dashboard == null) {
            throw new DashboardException("Can't create dashboard record. Wrong income data");
        }
        dashboard.setDashboardId(null);
        dashboard.setDateCreate(LocalDateTime.now());
        return dashboardRepository.save(dashboard);
    }

    @Override
    public DashboardEntity getDashboard(UUID uuid) throws DashboardException {
        return findDashboard(uuid);
    }

    @Override
    public DashboardEntity updateDashBoard(DashboardEntity dashboard) throws DashboardException {
        if (dashboard == null || dashboard.getDashboardId() == null) {
            throw new DashboardException("Can't update dashboard. Wrong income data");
        }
        DashboardEntity dashboardEntity = dashboardRepository.findById(dashboard.getDashboardId()).orElse(null);
        if (dashboardEntity == null) {
            throw new DashboardException("can't find dashboard by id");
        }
        BeanUtils.copyProperties(dashboard, dashboardEntity);
        dashboardEntity.setDateUpdate(LocalDateTime.now());
        dashboardEntity = dashboardRepository.save(dashboardEntity);
        EntityConverter.validateRest(dashboardEntity);
        return dashboardEntity;
    }

    @Override
    public boolean deleteDashboard(UUID uuid) throws DashboardException {
        DashboardEntity dashboardEntity = findDashboard(uuid);
        dashboardEntity.setState(false);
        dashboardRepository.save(dashboardEntity);
        return true;
    }

    private DashboardEntity findDashboard(UUID uuid) throws DashboardException {
        if (uuid == null) {
            throw new DashboardException("id of dashboard can't be null");
        }
        DashboardEntity dashboardEntity = dashboardRepository.findById(uuid).orElse(null);
        if (dashboardEntity == null) {
            throw new DashboardException("can't find dashboard by id");
        }
        return dashboardEntity;
    }

    @Override
    public boolean moveDashboard() {
        return false;
    }

    @Override
    public boolean addAccess(UUID userUuid, UUID accessTypeId, UUID dashboardId) {
        return false;
    }

    @Override
    public boolean changeAccess(UUID uuid, UUID accessTypeId, UUID dashboardId) {
        return false;
    }

    @Override
    public boolean removeAccess(UUID userId, UUID accessTypeId, UUID dashboardId) {
        return false;
    }
}
