package ru.sorb.dashboardserver;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ru.sorb.dashboardserver.entity.DashboardRecordEntity;
import ru.sorb.dashboardserver.repository.DashboardRecordRepository;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class DashboardServerApplicationTests {

    @Test
//    @Ignore
    void contextLoads() {
        DashboardRecordRepository dashboardRecordRepository = Mockito.mock(DashboardRecordRepository.class);
        DashboardRecordEntity recordEntity = new DashboardRecordEntity();
        Mockito.when(dashboardRecordRepository.findAll()).thenReturn(Collections.singletonList(recordEntity));
        DashboardRecordEntity record = dashboardRecordRepository.findAll().iterator().next();
        Assertions.assertNotNull(record);
        Assertions.assertNotNull(record.getUserAccessType());

    }

}
