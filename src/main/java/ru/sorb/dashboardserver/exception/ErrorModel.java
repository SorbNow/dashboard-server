package ru.sorb.dashboardserver.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorModel {
    private HttpStatus httpStatus;
    private LocalDateTime time;
    private String message;
    private String details;

    public ErrorModel(HttpStatus httpStatus, String message, String details) {
        this.httpStatus = httpStatus;
        this.time = LocalDateTime.now();
        this.message = message;
        this.details = details;
    }
}
