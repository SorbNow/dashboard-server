package ru.sorb.dashboardserver.service.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.UserEntity;
import ru.sorb.dashboardserver.exception.DashboardException;
import ru.sorb.dashboardserver.repository.UserRepository;
import ru.sorb.dashboardserver.util.EntityConverter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        userEntity.setId(null);
        userEntity.setDateCreate(LocalDateTime.now());
        EntityConverter.validateRest(userRepository.save(userEntity));
        return userEntity;
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) throws DashboardException {
        if (userEntity == null || userEntity.getId() == null) {
            throw new DashboardException("Wrong user entity for creating");
        }
        UserEntity user = userRepository.findById(userEntity.getId()).orElse(null);
        if (user == null) {
            throw new DashboardException("Can't find user by id");
        }
        userEntity.setLastChangeDate(LocalDateTime.now());
        userEntity = userRepository.save(userEntity);
        EntityConverter.validateRest(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity getUser(UUID id) throws DashboardException {
        if (id == null) {
            throw new DashboardException("id of user can't be null");
        }
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if (userEntity == null) {
            throw new DashboardException("Can't find user by id");
        }
        EntityConverter.validateRest(userEntity);
        return userEntity;
    }

    @Override
    public boolean deleteUser(UUID id) throws DashboardException {
        UserEntity user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setState(false);
            userRepository.save(user);
            return true;
        } else throw new DashboardException("Can't find user by id");
    }

    @Override
    public List<UserEntity> listUser(boolean isBlocked, boolean isDeleted, String username, boolean isLikeUsername, String email, boolean isLikeEmail, String fullName, boolean isLikeFullName, String fieldForOrder, boolean isAsc) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserEntity> q = cb.createQuery(UserEntity.class);
        Root<UserEntity> root = q.from(UserEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.and(cb.equal(root.get("is_blocked"), isBlocked)));
        predicates.add(cb.and(cb.equal(root.get("state"), !isDeleted)));
        if (!StringUtils.isBlank(username))
            predicates.add(cb.and(
                    isLikeUsername ?
                            cb.like(root.get("username"), username) :
                            cb.equal(root.get("username"), username)));
        if (!StringUtils.isBlank(email))
            predicates.add(cb.and(
                    isLikeEmail ?
                            cb.like(root.get("email"), email) :
                            cb.equal(root.get("email"), email)));
        if (!StringUtils.isBlank(fullName))
            predicates.add(cb.and(
                    isLikeFullName ?
                            cb.like(root.get("username"), fullName) :
                            cb.equal(root.get("username"), fullName)));
        List<Order> orderList = new ArrayList();
        orderList.add(isAsc ? cb.asc(root.get(fieldForOrder)) : cb.desc(root.get(fieldForOrder)));
        q.where(cb.and(predicates.toArray(new Predicate[0])));
        if (!orderList.isEmpty()) {
            q.orderBy(orderList);
        }
        q.select(root);

        TypedQuery<UserEntity> typedQuery = entityManager.createQuery(q);
        return typedQuery.getResultList();

    }


}
