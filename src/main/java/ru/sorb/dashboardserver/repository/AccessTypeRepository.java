package ru.sorb.dashboardserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sorb.dashboardserver.entity.AccessTypeEntity;

import java.util.UUID;

@Repository
public interface AccessTypeRepository extends CrudRepository<AccessTypeEntity, UUID> {
}
