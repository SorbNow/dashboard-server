package ru.sorb.dashboardserver.service.dashboardRecord;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.DashboardRecordEntity;

import java.util.UUID;

@Service
public interface DashboardRecordService {
    DashboardRecordEntity createDashboardRecord(DashboardRecordEntity dashboardRecord);

    DashboardRecordEntity getDashboardRecord(UUID uuid);

    DashboardRecordEntity updateDashboardRecord(DashboardRecordEntity dashboardRecord);

    boolean deleteDashboardRecord(UUID uuid);

    boolean moveDashboardToNextStage(UUID userId, UUID dashboardRecordId);
}
