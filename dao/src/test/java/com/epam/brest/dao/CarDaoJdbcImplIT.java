package com.epam.brest.dao;


import com.epam.brest.model.Car;
import com.epam.brest.testdb.SpringJdbcConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJdbcTest
@Import({CarDaoJdbcImpl.class})
@PropertySource({"classpath:dao-sql.properties"})
@ContextConfiguration(classes = SpringJdbcConfig.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback
public class CarDaoJdbcImplIT {

    private final Logger logger = LogManager.getLogger(CarDaoJdbcImpl.class);

    @Autowired
    private CarDaoJdbcImpl carDaoJdbcImpl;

    public CarDaoJdbcImplIT(CarDaoJdbcImpl carDaoJdbcImpl) {
        this.carDaoJdbcImpl = carDaoJdbcImpl;
    }

    @Test
    void findAllCars() {
        logger.info("Method findAllCars started");
        assertNotNull(carDaoJdbcImpl);
        assertNotNull(carDaoJdbcImpl.findAllCars());
    }

    @Test
    void findCarById() {
        logger.info("Method findCarById started");
        assertNotNull(carDaoJdbcImpl);
        List<Car> cars = carDaoJdbcImpl.findAllCars();
        if (cars.size() == 0) {
            carDaoJdbcImpl.createCar(new Car());
            cars = carDaoJdbcImpl.findAllCars();
        }
        Car carSrc = cars.get(0);
        Car carDst = carDaoJdbcImpl.findCarById(carSrc.getCarId());
        assertEquals(carSrc.getCarModel(), carDst.getCarModel());
    }

    @Test
    void createCar() {
        logger.info("Method saveCar started");
        assertNotNull(carDaoJdbcImpl);
        int countCarBeforeSave = carDaoJdbcImpl.countCars();
        Car car = new Car();
        carDaoJdbcImpl.createCar(car);
        int countCarAfterSave = carDaoJdbcImpl.countCars();
        assertEquals(countCarBeforeSave, countCarAfterSave - 1);
    }

    @Test
    void updateCarById() {
        logger.info("Method updateCarById started");
        assertNotNull(carDaoJdbcImpl);
        List<Car> cars = carDaoJdbcImpl.findAllCars();
        if (cars.size() == 0) {
            carDaoJdbcImpl.createCar(new Car());
            cars = carDaoJdbcImpl.findAllCars();
        }
        Car carSrc = cars.get(0);
        carSrc.setCarModel(carSrc.getCarModel() + "CARTEST");
        carDaoJdbcImpl.updateCarById(carSrc.getCarId(), carSrc);

        Car carDst = carDaoJdbcImpl.findCarById(carSrc.getCarId());
        assertEquals(carSrc.getCarModel(), carDst.getCarModel());
    }

    @Test
    void deleteCarById() {
        logger.info("Method deleteCarById started");
        carDaoJdbcImpl.createCar(new Car());
        List<Car> cars = carDaoJdbcImpl.findAllCars();
        carDaoJdbcImpl.deleteCarById(cars.get(cars.size() - 1).getCarId());
        assertEquals(cars.size() - 1, carDaoJdbcImpl.findAllCars().size());
    }

    @Test
    void countCars() {
        logger.info("Method countCars started");
        assertNotNull(carDaoJdbcImpl);
        Integer quantityCars = carDaoJdbcImpl.countCars();
        assertNotNull(quantityCars);
        assertTrue(quantityCars > 0);
        assertEquals(Integer.valueOf(3), quantityCars);
    }
}