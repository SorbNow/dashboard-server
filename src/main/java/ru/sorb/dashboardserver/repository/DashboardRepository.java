package ru.sorb.dashboardserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sorb.dashboardserver.entity.Dashboard;

import java.util.UUID;

@Repository
public interface DashboardRepository extends CrudRepository<Dashboard, UUID> {
}
