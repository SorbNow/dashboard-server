package ru.sorb.dashboardserver.controller.dashboardRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sorb.dashboardserver.controller.DefaultCrudControllerOperations;
import ru.sorb.dashboardserver.entity.DashboardRecordEntity;
import ru.sorb.dashboardserver.exception.DashboardException;
import ru.sorb.dashboardserver.service.dashboardRecord.DashboardRecordService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/dashboard/record")
public class DashboardRecordController implements DefaultCrudControllerOperations<DashboardRecordEntity> {

    private final DashboardRecordService dashboardRecordService;

    @Autowired
    public DashboardRecordController(DashboardRecordService dashboardRecordService) {
        this.dashboardRecordService = dashboardRecordService;
    }

    @GetMapping("/{recordId}")
    @Override
    public DashboardRecordEntity getRecord(@PathVariable UUID recordId) throws DashboardException {
        return dashboardRecordService.getDashboardRecord(recordId);
    }

    @PostMapping
    @Override
    public DashboardRecordEntity createRecord(@RequestBody @Valid DashboardRecordEntity record) throws DashboardException {
        return dashboardRecordService.createDashboardRecord(record);
    }

    @PutMapping
    @Override
    public DashboardRecordEntity updateRecord(@RequestBody @Valid DashboardRecordEntity record) throws DashboardException {
        return dashboardRecordService.updateDashboardRecord(record);
    }

    @DeleteMapping("/{recordId}")
    @Override
    public boolean deleteRecord(@PathVariable UUID recordId) throws DashboardException {
        return dashboardRecordService.deleteDashboardRecord(recordId);
    }

    @GetMapping("/{recordId}/next")
    public DashboardRecordEntity moveRecordToNextStep(@PathVariable UUID recordId) throws DashboardException {
        return dashboardRecordService.moveDashboardRecordToNextStage(null, recordId);
    }
}
