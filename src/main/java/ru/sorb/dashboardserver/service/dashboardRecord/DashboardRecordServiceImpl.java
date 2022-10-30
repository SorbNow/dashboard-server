package ru.sorb.dashboardserver.service.dashboardRecord;

import ru.sorb.dashboardserver.entity.DashboardRecord;

import java.util.UUID;


public class DashboardRecordServiceImpl implements DashboardRecordService {
    @Override
    public DashboardRecord createDashboardRecord(DashboardRecord dashboardRecord) {
        return null;
    }

    @Override
    public DashboardRecord getDashboardRecord(UUID uuid) {
        return null;
    }

    @Override
    public DashboardRecord updateDashboardRecord(DashboardRecord dashboardRecord) {
        return null;
    }

    @Override
    public boolean deleteDashboardRecord(UUID uuid) {
        return false;
    }

    @Override
    public boolean moveDashboardToNextStage(UUID userId, UUID dashboardRecordId) {
        return false;
    }
}
