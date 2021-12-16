DROP TABLE IF EXISTS driver;
CREATE TABLE driver(
    driverId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(20) NOT NULL,
    lastName VARCHAR(20) NOT NULL,
    driverLicence VARCHAR(9) NOT NULL UNIQUE,
    workDate TIMESTAMP NOT NULL,
    salary DECIMAL NOT NULL,
    CONSTRAINT driver_pk PRIMARY KEY (driverId)
);
DROP TABLE IF EXISTS car;
CREATE TABLE car (
    carId INT NOT NULL AUTO_INCREMENT,
    nameCar VARCHAR(20) INT NOT NULL,
    typeCar VARCHAR(20) NOT NULL,
    driverId INT NOT NULL,
    CONSTRAINT car_pk PRIMARY KEY (carId),
    CONSTRAINT car_driver_fk FOREIGN KEY (driverId) REFERENCES driver (driverId)
  );
)