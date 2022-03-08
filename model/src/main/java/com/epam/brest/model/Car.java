package com.epam.brest.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Car {

    private Integer carId;

    private String carModel;

    private BigDecimal carMileAge;

    private Integer driverId;

    public Car(Integer carId, String carModel, BigDecimal carMileAge, Integer driverId) {
        this.carId = carId;
        this.carModel = carModel;
        this.carMileAge = carMileAge;
        this.driverId = driverId;
    }
    public Car() {
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public BigDecimal getCarMileAge() {
        return carMileAge;
    }

    public void setCarMileAge(BigDecimal carMileAge) {
        this.carMileAge = carMileAge;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return carId.equals(car.carId) && carModel.equals(car.carModel) && carMileAge.equals(car.carMileAge) && driverId.equals(car.driverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, carModel, carMileAge, driverId);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carModel='" + carModel + '\'' +
                ", carMileAge=" + carMileAge +
                ", driverId=" + driverId +
                '}';
    }
}
