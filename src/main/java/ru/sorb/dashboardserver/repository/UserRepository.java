package ru.sorb.dashboardserver.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sorb.dashboardserver.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
