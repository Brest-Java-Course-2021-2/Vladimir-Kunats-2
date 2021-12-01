package com.epam.brest;

import java.sql.Driver;

public interface DriverService {
    Driver getDriverById(Integer driverId);

    Integer create(Driver driver);

    Integer update(Driver driver);

    Integer delete(Integer driverId);

    Integer count();
}
