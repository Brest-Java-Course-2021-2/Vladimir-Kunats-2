package com.epam.brest.dao.queries;

import org.springframework.stereotype.Component;

@Component
public class SqlQueriesDriver {

    /**
     * Field SQL_DRIVER_FIND_ALL.
     */

    public static final String SQL_DRIVER_FIND_ALL = "SELECT * FROM driver";

    /**
     * Field SQL_DRIVER_FIND_BY_ID.
     */

    public static final String SQL_DRIVER_FIND_BY_ID = "SELECT * FROM driver WHERE driver_id=:driverId";

    /**
     * Field SQL_DRIVER_CREATE.
     */

    public static final String SQL_DRIVER_CREATE = "INSERT INTO driver (driverfirstname , driverlastname , driverworkdate, driverlicence, driversalary)"
                    + " VALUES (:driverFirstName, :driverLastName, :driverWorkDate, :driverLicense, :driverSalary)";

    /**
     * Field SQL_DRIVER_UPDATE_BY_ID.
     */

    public static final String SQL_DRIVER_UPDATE_BY_ID = "UPDATE driver SET firstname=:driverFirstName, lastname = :driverLastName,  workdate=:driverWorkDate,"
                    + "license = :driverLicense, salary=:driverSalary WHERE driver_id=:driverId";

    /**
     * Field SQL_DRIVER_DELETE_BY_ID.
     */

    public static final String SQL_DRIVER_DELETE_BY_ID = "DELETE FROM driver WHERE driver_id=:driverId";

    /**
     * Field SQL_DRIVER_UNIQUE_LICENSE.
     */

    public static final String SQL_DRIVER_UNIQUE_LICENSE = "SELECT COUNT(d.license) FROM driver d WHERE lower(d.license)=lower(:driverLicense)";

    /**
     * Field SQL_DRIVER_COUNT.
     */

    public static final String SQL_DRIVER_COUNT = "SELECT COUNT(*) FROM driver";

    /**
     * Field SQL_DRIVERS_WITH_AVG_SALARY.
     */

    public static final String SQL_DRIVERS_WITH_AVG_SALARY =
            "SELECT driverfirstname , driverlastname , driverlicence, AVG (driversalary) FROM driver";
}
