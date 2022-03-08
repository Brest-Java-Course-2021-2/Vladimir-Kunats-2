package com.epam.brest.dao.queries;

import org.springframework.stereotype.Component;

@Component
public class SqlQueriesCar {
    /**
     * Field CAR_FIND_ALL.
     */

    public static final String SQL_CAR_FIND_ALL = "SELECT * FROM car";

    /**
     * Field CAR_FIND_BY_ID.
     */

    public static final String SQL_CAR_FIND_BY_ID = "SELECT * FROM car WHERE car_id=:carId";

    /**
     * Field CAR_SAVE.
     */

    public static final String SQL_CAR_CREATE = "INSERT INTO car (model, mileage, driver_id) VALUES (:carModel, :carMileAge, :driverId)";

    /**
     * Field CAR_UPDATE_BY_ID.
     */

    public static final String SQL_CAR_UPDATE_BY_ID = "UPDATE car SET model=:carModel, mileage=:carMileAge, driver_id=:driverId WHERE car_id=:carId";

    /**
     * Field CAR_DELETE_BY_ID.
     */

    public static final String SQL_CAR_DELETE_BY_ID = "DELETE FROM car WHERE car_id=:carId";

    /**
     * Field CAR_COUNT.
     */

    public static final String SQL_CAR_ALL_COUNT = "SELECT count(*) FROM car";
}
