package ru.sorb.dashboardserver.service.dashboardRecord;

import ru.sorb.dashboardserver.entity.DashboardRecordEntity;

import java.util.UUID;


public class DashboardRecordServiceImpl implements DashboardRecordService {
    @Override
    public DashboardRecordEntity createDashboardRecord(DashboardRecordEntity dashboardRecord) {
        return null;
    }

    @Override
    public DashboardRecordEntity getDashboardRecord(UUID uuid) {
        return null;
    }

    @Override
    public DashboardRecordEntity updateDashboardRecord(DashboardRecordEntity dashboardRecord) {
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
