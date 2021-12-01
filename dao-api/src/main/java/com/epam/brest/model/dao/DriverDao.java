package com.epam.brest.model.dao;
import com.epam.brest.model.Driver;

import java.util.List;

public interface DriverDao {
    List<Driver> findAll();
    Integer create (Driver driver);
    Integer update (Driver driver);
    Integer delete (Integer driverId);
    Driver getDriverById(Integer driverId);
    Integer count();
}
