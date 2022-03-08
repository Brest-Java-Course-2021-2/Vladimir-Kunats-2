package com.epam.brest.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

public class Driver {

    private Integer driverId;
    private String driverFirstName;
    private String driverLastName;
    private Instant driverWorkDate;
    private String driverLicense;
    private BigDecimal driverSalary;

    public Driver() {
    }

    public Driver(Integer driverId, String driverFirstName, String driverLastName, Instant driverWorkDate, String driverLicense, BigDecimal driverSalary) {
        this.driverId = driverId;
        this.driverFirstName = driverFirstName;
        this.driverLastName = driverLastName;
        this.driverWorkDate = driverWorkDate;
        this.driverLicense = driverLicense;
        this.driverSalary = driverSalary;
            }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public void setDriverFirstName(String driverFirstName) {
        this.driverFirstName = driverFirstName;
    }

    public String getDriverLastName() {
        return driverLastName;
    }

    public void setDriverLastName(String driverLastName) {
        this.driverLastName = driverLastName;
    }

    public Instant getDriverWorkDate() {
        return driverWorkDate;
    }

    public void setDriverWorkDate(Instant driverWorkDate) {
        this.driverWorkDate = driverWorkDate;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public BigDecimal getDriverSalary() {
        return driverSalary;
    }

    public void setDriverSalary(BigDecimal driverSalary) {
        this.driverSalary = driverSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return driverId.equals(driver.driverId) && driverFirstName.equals(driver.driverFirstName) && driverLastName.equals(driver.driverLastName) && driverWorkDate.equals(driver.driverWorkDate) && driverLicense.equals(driver.driverLicense) && driverSalary.equals(driver.driverSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId, driverFirstName, driverLastName, driverWorkDate, driverLicense, driverSalary);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", driverFirstName='" + driverFirstName + '\'' +
                ", driverLastName='" + driverLastName + '\'' +
                ", driverWorkDate=" + driverWorkDate +
                ", driverLicense='" + driverLicense + '\'' +
                ", driverSalary=" + driverSalary +
                '}';
    }
}

