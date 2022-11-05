package ru.sorb.dashboardserver.controller.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sorb.dashboardserver.controller.DefaultCrudControllerOperations;
import ru.sorb.dashboardserver.entity.DashboardEntity;
import ru.sorb.dashboardserver.exception.DashboardException;
import ru.sorb.dashboardserver.service.dashboard.DashboardService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/dashboard")
public class DashboardController implements DefaultCrudControllerOperations<DashboardEntity> {

    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/{dashboardId}")
    @Override
    public DashboardEntity getRecord(@PathVariable UUID dashboardId) throws DashboardException {
        return dashboardService.getDashboard(dashboardId);
    }

    @PostMapping
    @Override
    public DashboardEntity createRecord(@Valid @RequestBody DashboardEntity record) throws DashboardException {
        return dashboardService.createDashboard(record);
    }

    @PutMapping
    @Override
    public DashboardEntity updateRecord(@RequestBody @Valid DashboardEntity record) throws DashboardException {
        return dashboardService.updateDashBoard(record);
    }

    @DeleteMapping("{dashboardId}")
    @Override
    public boolean deleteRecord(@PathVariable UUID dashboardId) throws DashboardException {
        return dashboardService.deleteDashboard(dashboardId);
    }
}
