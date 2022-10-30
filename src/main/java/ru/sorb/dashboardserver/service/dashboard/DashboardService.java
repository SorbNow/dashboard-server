package ru.sorb.dashboardserver.service.dashboard;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.Dashboard;

import java.util.UUID;

@Service
public interface DashboardService {
    Dashboard createDashboard(Dashboard dashboard);
    Dashboard getDashboard(UUID uuid);
    Dashboard updateDashBoard(Dashboard dashboard);
    Dashboard deleteDashboard(UUID uuid);
}
