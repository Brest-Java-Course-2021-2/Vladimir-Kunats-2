package com.epam.brest.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Driver {
    private Integer driverId;
    private String firstName;
    private String lastName;
    private double distance;
    private BigDecimal sallary;

    public Driver(Integer driverId, String firstName, String lastName, double distance, BigDecimal sallary) {
        this.driverId = driverId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.distance = distance;
        this.sallary = sallary;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public BigDecimal getSallary() {
        return sallary;
    }

    public void setSallary(BigDecimal sallary) {
        this.sallary = sallary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Double.compare(driver.distance, distance) == 0 && driverId.equals(driver.driverId) && firstName.equals(driver.firstName) && lastName.equals(driver.lastName) && sallary.equals(driver.sallary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId, firstName, lastName, distance, sallary);
    }
}