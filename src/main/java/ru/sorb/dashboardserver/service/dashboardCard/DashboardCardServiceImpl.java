package ru.sorb.dashboardserver.service.dashboardCard;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.DashboardCardEntity;
import ru.sorb.dashboardserver.entity.DashboardEntity;
import ru.sorb.dashboardserver.exception.DashboardException;
import ru.sorb.dashboardserver.repository.DashboardCardRepository;
import ru.sorb.dashboardserver.util.EntityConverter;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class DashboardCardServiceImpl implements DashboardCardService {

    private final DashboardCardRepository dashboardCardRepository;

    @Autowired
    public DashboardCardServiceImpl(DashboardCardRepository dashboardCardRepository) {
        this.dashboardCardRepository = dashboardCardRepository;
    }

    @Override
    public DashboardCardEntity createDashboardCard(DashboardCardEntity dashboardCard) throws DashboardException {
        if (dashboardCard == null) {
            throw new DashboardException("Can't create dashboard card record. Wrong income data");
        }
        dashboardCard.setCardId(null);
        dashboardCard.setDateCreate(LocalDateTime.now());
        return dashboardCardRepository.save(dashboardCard);
    }

    @Override
    public DashboardCardEntity getDashboardCard(UUID uuid) throws DashboardException {
        return findDashboardCard(uuid);
    }

    @Override
    public DashboardCardEntity updateDashBoard(DashboardCardEntity dashboardCard) throws DashboardException {
        if (dashboardCard == null || dashboardCard.getCardId() == null) {
            throw new DashboardException("Can't update dashboard card. Wrong income data");
        }
        DashboardCardEntity dashboardCardEntity = dashboardCardRepository.findById(dashboardCard.getCardId()).orElse(null);
        if (dashboardCardEntity == null) {
            throw new DashboardException("can't find dashboard card by id");
        }
        BeanUtils.copyProperties(dashboardCard, dashboardCardEntity);
        dashboardCardEntity.setDateUpdate(LocalDateTime.now());
        dashboardCardEntity = dashboardCardRepository.save(dashboardCardEntity);
        EntityConverter.validateRest(dashboardCardEntity);
        return dashboardCardEntity;
    }

    @Override
    public boolean deleteDashboardCard(UUID uuid) throws DashboardException {
        DashboardCardEntity dashboardEntity = findDashboardCard(uuid);
        dashboardEntity.setState(false);
        dashboardCardRepository.save(dashboardEntity);
        return true;
    }

    private DashboardCardEntity findDashboardCard(UUID uuid) throws DashboardException {
        if (uuid == null) {
            throw new DashboardException("id of dashboard card can't be null");
        }
        DashboardCardEntity dashboardCardEntity = dashboardCardRepository.findById(uuid).orElse(null);
        if (dashboardCardEntity == null) {
            throw new DashboardException("can't find dashboard card by id");
        }
        return dashboardCardEntity;
    }
}
