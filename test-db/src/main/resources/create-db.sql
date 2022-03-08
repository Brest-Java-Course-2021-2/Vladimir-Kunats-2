DROP TABLE IF EXISTS driver;

DROP TABLE IF EXISTS car;

CREATE TABLE driver (
    driverId int NOT NULL auto_increment,
    driverfirstname varchar(50) NOT NULL,
    driverlastname varchar(50) NOT NULL,
    driverworkdate date NOT NULL,
    driverlicense varchar(9) NOT NULL UNIQUE,
    driversalary decimal NOT NULL,
    CONSTRAINT driver_pk PRIMARY KEY (driverId)
);

CREATE TABLE car (
    carId int NOT NULL auto_increment,
    carmodel varchar(255) NOT NULL,
    carmileage decimal NOT NULL,
    driverId int NOT NULL,
        CONSTRAINT car_pk PRIMARY KEY (carId),
        CONSTRAINT car_driver_fk FOREIGN KEY (driverId) REFERENCES driver(driverId)
);