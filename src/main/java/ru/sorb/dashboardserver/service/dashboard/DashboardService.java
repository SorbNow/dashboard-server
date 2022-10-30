package ru.sorb.dashboardserver.service.dashboard;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.Dashboard;

import java.util.UUID;

@Service
public interface DashboardService {
    Dashboard createDashboard(Dashboard dashboard);
    Dashboard getDashboard(UUID uuid);
    Dashboard updateDashBoard(Dashboard dashboard);
    boolean deleteDashboard(UUID uuid);
    boolean moveDashboard();
    boolean addAccess(UUID userUuid, UUID accessTypeId, UUID dashboardId);
    boolean changeAccess(UUID uuid, UUID accessTypeId, UUID dashboardId);
    boolean removeAccess(UUID userId, UUID accessTypeId, UUID dashboardId);
}
