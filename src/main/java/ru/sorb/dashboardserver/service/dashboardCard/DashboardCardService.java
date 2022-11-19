package ru.sorb.dashboardserver.service.dashboardCard;

import ru.sorb.dashboardserver.entity.DashboardCardEntity;
import ru.sorb.dashboardserver.exception.DashboardException;

import java.util.UUID;


public interface DashboardCardService {
    DashboardCardEntity createDashboardCard(DashboardCardEntity dashboardCard) throws DashboardException;

    DashboardCardEntity getDashboardCard(UUID uuid) throws DashboardException;

    DashboardCardEntity updateDashBoard(DashboardCardEntity dashboardCard) throws DashboardException;

    boolean deleteDashboardCard(UUID uuid) throws DashboardException;
}
