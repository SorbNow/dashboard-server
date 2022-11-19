package ru.sorb.dashboardserver.controller.dashboardCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.sorb.dashboardserver.controller.DefaultCrudControllerOperations;
import ru.sorb.dashboardserver.entity.DashboardCardEntity;
import ru.sorb.dashboardserver.exception.DashboardException;
import ru.sorb.dashboardserver.service.dashboardCard.DashboardCardService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/dashboard/card")
public class DashboardCardController implements DefaultCrudControllerOperations<DashboardCardEntity> {

    private final DashboardCardService dashboardCardService;

    @Autowired
    public DashboardCardController(DashboardCardService dashboardCardService) {
        this.dashboardCardService = dashboardCardService;
    }

    @Override
    @GetMapping("/{dashboardCardId}")
    public DashboardCardEntity getRecord(@PathVariable UUID dashboardCardId) throws DashboardException {
        return dashboardCardService.getDashboardCard(dashboardCardId);
    }

    @Override
    @PostMapping
    public DashboardCardEntity createRecord(@Valid @RequestBody DashboardCardEntity record) throws DashboardException {
        return dashboardCardService.createDashboardCard(record);
    }

    @Override
    @PutMapping
    public DashboardCardEntity updateRecord(@RequestBody @Valid DashboardCardEntity record) throws DashboardException {
        return dashboardCardService.updateDashBoard(record);
    }

    @Override
    @DeleteMapping("/{dashboardCardId}")
    public boolean deleteRecord(@PathVariable UUID dashboardCardId) throws DashboardException {
        return false;
    }
}
