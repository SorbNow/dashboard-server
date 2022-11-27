package ru.sorb.dashboardserver.listener;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import ru.sorb.dashboardserver.entity.AccessTypeEntity;
import ru.sorb.dashboardserver.entity.DashboardRecordEntity;

import java.util.Collections;

@Aspect
public class DashboardRecordListener {


    @Pointcut("execution(* DashboardRecordEntity.getUserAccessType(..))")
    public void executeMethods() {
    }

    @Around("executeMethods()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Going to call the method.");
        Object target = pjp.getTarget();
        if (target instanceof DashboardRecordEntity) {
            AccessTypeEntity userAccessTypeEntity = new AccessTypeEntity();
            userAccessTypeEntity.setName("shit");
            ((DashboardRecordEntity) target).setUserAccessType(Collections.singletonList(userAccessTypeEntity));

        }
        System.out.println("Method execution completed.");
        return target;
    }
}
