package com.epam.brest.dao;

public class SqlQueries {
    public static final String SQL_ALL_DRIVER = "select d.firstName, d.lastName, d.driverLicence, d.workDate from driver d order by d.driverLicence";
    public static final String SQL_CREATE_DRIVER = "insert into driver(driverLicence) values (:driverLicence)";
}
