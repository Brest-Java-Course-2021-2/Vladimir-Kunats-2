package com.epam.brest.model;

import java.util.Objects;

public class Car {
    private Integer carId;

    private String nameCar;

    private String modelCar;

    private String typeCar;
    private Integer driverId;

    public Car(Integer carId, String nameCar, String modelCar, String typeCar, Integer driverId) {
        this.carId = carId;
        this.nameCar = nameCar;
        this.modelCar = modelCar;
        this.typeCar = typeCar;
        this.driverId = driverId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
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
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId.equals(car.carId) && nameCar.equals(car.nameCar) && modelCar.equals(car.modelCar) && typeCar.equals(car.typeCar) && driverId.equals(car.driverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, nameCar, modelCar, typeCar, driverId);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", nameCar='" + nameCar + '\'' +
                ", modelCar='" + modelCar + '\'' +
                ", typeCar='" + typeCar + '\'' +
                ", driverId=" + driverId +
                '}';
    }
}

