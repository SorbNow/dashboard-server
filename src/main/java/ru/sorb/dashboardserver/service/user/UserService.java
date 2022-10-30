package ru.sorb.dashboardserver.service.user;

import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.User;

@Service
public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    User getUser(Long id);
    User deleteUser(Long id);
}
