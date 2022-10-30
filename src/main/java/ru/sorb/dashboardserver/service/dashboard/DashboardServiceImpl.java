package ru.sorb.dashboardserver.service.dashboard;

import ru.sorb.dashboardserver.entity.Dashboard;

import java.util.UUID;


public class DashboardServiceImpl implements DashboardService {
    @Override
    public Dashboard createDashboard(Dashboard dashboard) {
        return null;
    }

    @Override
    public Dashboard getDashboard(UUID uuid) {
        return null;
    }

    @Override
    public Dashboard updateDashBoard(Dashboard dashboard) {
        return null;
    }

    @Override
    public boolean deleteDashboard(UUID uuid) {
        return false;
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
