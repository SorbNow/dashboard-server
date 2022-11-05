package ru.sorb.dashboardserver.controller;

import ru.sorb.dashboardserver.exception.DashboardException;

import java.util.UUID;

public interface DefaultCrudControllerOperations<T> {
    T getRecord(UUID uuid) throws DashboardException;

    T createRecord(T record) throws DashboardException;

    T updateRecord(T record) throws DashboardException;

    boolean deleteRecord(UUID uuid) throws DashboardException;
}
