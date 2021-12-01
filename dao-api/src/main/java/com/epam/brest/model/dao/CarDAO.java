package com.epam.brest.model.dao;

import com.epam.brest.model.Car;

import java.util.List;

public interface CarDAO {
    List<Car> findAllCar();
    Car getAccountById(Integer carId);
    Integer create(Car car);
    Integer update(Car car);
    Integer delete (Integer carId);
}
