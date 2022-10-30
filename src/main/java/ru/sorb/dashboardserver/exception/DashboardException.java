package ru.sorb.dashboardserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DashboardException extends Exception {
    public DashboardException(String message) {
        super(message);
    }
}
