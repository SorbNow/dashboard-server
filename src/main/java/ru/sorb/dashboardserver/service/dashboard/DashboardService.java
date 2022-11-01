package ru.sorb.dashboardserver.service.dashboard;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.DashboardEntity;
import ru.sorb.dashboardserver.exception.DashboardException;

import java.util.UUID;

@Service
public interface DashboardService {
    DashboardEntity createDashboard(DashboardEntity dashboard);
    DashboardEntity getDashboard(UUID uuid) throws DashboardException;
    DashboardEntity updateDashBoard(DashboardEntity dashboard) throws DashboardException;
    boolean deleteDashboard(UUID uuid) throws DashboardException;
    boolean moveDashboard();
    boolean addAccess(UUID userUuid, UUID accessTypeId, UUID dashboardId);
    boolean changeAccess(UUID uuid, UUID accessTypeId, UUID dashboardId);
    boolean removeAccess(UUID userId, UUID accessTypeId, UUID dashboardId);
}
