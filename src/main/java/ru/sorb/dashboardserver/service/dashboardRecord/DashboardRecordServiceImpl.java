package ru.sorb.dashboardserver.service.dashboardRecord;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sorb.dashboardserver.entity.DashboardEntity;
import ru.sorb.dashboardserver.entity.DashboardRecordEntity;
import ru.sorb.dashboardserver.exception.DashboardException;
import ru.sorb.dashboardserver.repository.DashboardRecordRepository;
import ru.sorb.dashboardserver.repository.DashboardRepository;
import ru.sorb.dashboardserver.util.EntityConverter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class DashboardRecordServiceImpl implements DashboardRecordService {

    private final DashboardRecordRepository recordRepository;

    private final DashboardRepository dashboardRepository;

    @Autowired
    public DashboardRecordServiceImpl(DashboardRecordRepository recordRepository, DashboardRepository dashboardRepository) {
        this.recordRepository = recordRepository;
        this.dashboardRepository = dashboardRepository;
    }

    @Override
    public DashboardRecordEntity createDashboardRecord(DashboardRecordEntity dashboardRecord) throws DashboardException {
        if (dashboardRecord == null) {
            throw new DashboardException("Can't create dashboard record. Wrong income data");
        }
        dashboardRecord.setDashboardRecordId(null);
        dashboardRecord.setDateCreate(LocalDateTime.now());

        return recordRepository.save(dashboardRecord);
    }

    @Override
    public DashboardRecordEntity getDashboardRecord(UUID uuid) throws DashboardException {
        if (uuid == null) {
            throw new DashboardException("wrong incoming data! id can't be null");
        }
        DashboardRecordEntity dashboardRecordEntity = recordRepository.findById(uuid).orElse(null);
        if (dashboardRecordEntity == null) {
            throw new DashboardException("Can't find dashboard record by id");
        }
        return dashboardRecordEntity;
    }

    @Override
    public DashboardRecordEntity updateDashboardRecord(DashboardRecordEntity dashboardRecord) throws DashboardException {
        if (dashboardRecord == null || dashboardRecord.getDashboardRecordId() == null) {
            throw new DashboardException("Wrong incoming data. Can't update dashboard record");
        }
        DashboardRecordEntity dashboardRecordEntity = recordRepository.findById(dashboardRecord.getDashboardRecordId()).orElse(null);
        if (dashboardRecordEntity == null) {
            throw new DashboardException("can't find dashboard record by id");
        }
        BeanUtils.copyProperties(dashboardRecordEntity, dashboardRecord);
        dashboardRecordEntity.setDateUpdate(LocalDateTime.now());
        dashboardRecordEntity = recordRepository.save(dashboardRecordEntity);
        EntityConverter.validateRest(dashboardRecordEntity);
        return dashboardRecordEntity;
    }

    @Override
    public boolean deleteDashboardRecord(UUID uuid) throws DashboardException {
        if (uuid == null) {
            throw new DashboardException("Wrong incoming data. Id can't be null");
        }
        DashboardRecordEntity dashboardRecordEntity = recordRepository.findById(uuid).orElse(null);
        if (dashboardRecordEntity == null) {
            throw new DashboardException("Can't find dashboard record by id");
        }
        dashboardRecordEntity.setDateUpdate(LocalDateTime.now());
        return true;
    }

    @Override
    public boolean moveDashboardRecordToNextStage(UUID userId, UUID dashboardRecordId) throws DashboardException {
        DashboardRecordEntity dashboardRecordEntity = recordRepository.findById(dashboardRecordId).orElse(null);
        if (dashboardRecordEntity == null) {
            throw new DashboardException("Can't find dashboard record by id");
        }
        DashboardEntity dashboardEntity = dashboardRepository.findById(dashboardRecordEntity.getDashboardRecordId())
                .orElse(null);
        if (dashboardEntity == null) {
            throw new DashboardException("Error next step finding");
        }
        List<DashboardEntity> dashboardEntities =
                dashboardRepository.findDashboardEntitiesByStepNumber(dashboardEntity.getStepNumber() + 1);
        if (dashboardEntities.size() == 1) {
            dashboardRecordEntity.setDashboardEntity(dashboardEntities.get(0));
            dashboardRecordEntity.setDateUpdate(LocalDateTime.now());
            recordRepository.save(dashboardRecordEntity);
            return true;
        } else throw new DashboardException("Error next step finding. More than 1 dashboard can be selected");
    }
}
