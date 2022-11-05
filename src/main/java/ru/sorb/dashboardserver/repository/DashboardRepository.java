package ru.sorb.dashboardserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sorb.dashboardserver.entity.DashboardEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface DashboardRepository extends CrudRepository<DashboardEntity, UUID> {
    List<DashboardEntity> findDashboardEntitiesByStepNumber(Integer stepNUmber);
}
