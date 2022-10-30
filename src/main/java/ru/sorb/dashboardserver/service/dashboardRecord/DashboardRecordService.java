package ru.sorb.dashboardserver.service.dashboardRecord;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.DashboardRecord;

import java.util.UUID;

@Service
public interface DashboardRecordService {
    DashboardRecord createDashboardRecord(DashboardRecord dashboardRecord);

    DashboardRecord getDashboardRecord(UUID uuid);

    DashboardRecord updateDashboardRecord(DashboardRecord dashboardRecord);

    boolean deleteDashboardRecord(UUID uuid);

    boolean moveDashboardToNextStage(UUID userId, UUID dashboardRecordId);
}
