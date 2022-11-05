package ru.sorb.dashboardserver.service.dashboardRecord;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.DashboardRecordEntity;
import ru.sorb.dashboardserver.exception.DashboardException;

import java.util.UUID;

@Service
public interface DashboardRecordService {
    DashboardRecordEntity createDashboardRecord(DashboardRecordEntity dashboardRecord) throws DashboardException;

    DashboardRecordEntity getDashboardRecord(UUID uuid) throws DashboardException;

    DashboardRecordEntity updateDashboardRecord(DashboardRecordEntity dashboardRecord) throws DashboardException;

    boolean deleteDashboardRecord(UUID uuid) throws DashboardException;

    boolean moveDashboardRecordToNextStage(UUID userId, UUID dashboardRecordId) throws DashboardException;
}
