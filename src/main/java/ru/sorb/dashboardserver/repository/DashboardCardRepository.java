package ru.sorb.dashboardserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sorb.dashboardserver.entity.DashboardCardEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface DashboardCardRepository extends CrudRepository<DashboardCardEntity, UUID> {
    List<DashboardCardEntity> findDashboardCardEntitiesByStepNumber(Integer stepNumber);
}
