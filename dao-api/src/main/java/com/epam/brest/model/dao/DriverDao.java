package com.epam.brest.model.dao;
import com.epam.brest.model.Driver;

import java.util.List;

public interface DriverDao {
    List<Driver> findAllDrivers();
    Integer createDriver (Driver driver);
    Integer updateDriver (Driver driver);
    Integer deleteDriver (Integer driverId);
    Driver getDriverById(Integer driverId);
    Integer countDriver();

}
