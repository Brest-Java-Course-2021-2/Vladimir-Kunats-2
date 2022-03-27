package com.epam.brest.dao;

import com.epam.brest.model.Driver;
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
import static org.junit.jupiter.api.Assertions.assertEquals;

//@DataJdbcTest
@Import({DriverDaoJdbcImpl.class})
@PropertySource({"classpath:dao.properties"})
@ContextConfiguration(classes = SpringJdbcConfig.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback
class DriverDaoJdbcImplIT {

    private final Logger logger = LogManager.getLogger(DriverDaoJdbcImplIT.class);

    private DriverDaoJdbcImpl driverDaoJdbcImpl;

    public DriverDaoJdbcImplIT(@Autowired DriverDao driverDaoJdbcImpl) {
        this.driverDaoJdbcImpl = (DriverDaoJdbcImpl) driverDaoJdbcImpl;
    }

    @Test
    void findAllDrivers() {
        logger.info("Method findAllDrivers started in class DriverDaoJdbcImplIT");
        assertNotNull(driverDaoJdbcImpl);
        assertNotNull(driverDaoJdbcImpl.findAllDrivers());
    }

    @Test
    void findDriverById() {
        logger.info("Method findCarById started in class DriverDaoJdbcImplIT");
        assertNotNull(driverDaoJdbcImpl);
        List<Driver> drivers = driverDaoJdbcImpl.findAllDrivers();
        if(drivers.size() == 0) {
            driverDaoJdbcImpl.createDriver(new Driver("Test", "12/08/2021", "Test", 1000));
            drivers = driverDaoJdbcImpl.findAllDrivers();
        }
        Driver driverSrc = drivers.get(0);
        Driver driverDst = driverDaoJdbcImpl.findDriverById(driverSrc.getDriverId());
        assertEquals(driverSrc.getDriverLicense(), driverDst.getDriverLicense());
    }

    @Test
    void createDriver() {
        logger.info("Method createDriver started in class DriverDaoJdbcImplIT");
        assertNotNull(driverDaoJdbcImpl);
        int countCarBeforeCreate = driverDaoJdbcImpl.countDrivers();
        Driver driver = new Driver("Test", "12/08/2021", "Test", 1000);
        driverDaoJdbcImpl.createDriver(new Driver("Test", "12/08/2021", "Test", 1000));
        int countDriverAfterCreate = driverDaoJdbcImpl.countDrivers();
        assertEquals(countCarBeforeCreate, countDriverAfterCreate - 1);
    }

    @Test
    void updateDriverById() {
        logger.info("Method updateDriverById started in class DriverDaoJdbcImplIT");
        assertNotNull(driverDaoJdbcImpl);
        List<Driver> drivers = driverDaoJdbcImpl.findAllDrivers();
        if (drivers.size() == 0) {
            driverDaoJdbcImpl.createDriver(new Driver( "Test", "12/08/2021", "Test", 1000));
            drivers = driverDaoJdbcImpl.findAllDrivers();
        }

        Driver driverSrc = drivers.get(0);
        driverSrc.setDriverLicense(driverSrc.getDriverLicense() + "DriverTest");
        driverSrc.setDriverLastName(driverSrc.getDriverLastName() + "DriverTest");
        driverDaoJdbcImpl.updateDriverById(driverSrc.getDriverId(), driverSrc);
        Driver driverDst = driverDaoJdbcImpl.findDriverById(driverSrc.getDriverId());
        assertEquals(driverSrc.getDriverLicense(), driverDst.getDriverLicense());
    }

    @Test
    void deleteDriverById() {
        logger.info("Method deleteDriverById started in class DriverDaoJdbcImplIT");
        driverDaoJdbcImpl.createDriver(new Driver("Test", "12/08/2021", "Test", 1000));
        List<Driver> drivers = driverDaoJdbcImpl.findAllDrivers();
        driverDaoJdbcImpl.deleteDriverById(drivers.get(drivers.size() - 1).getDriverId());
        assertEquals(drivers.size() - 1, driverDaoJdbcImpl.findAllDrivers().size());
    }

    @Test
    void countDrivers() {
        logger.info("Method countDrivers started in class DriverDaoJdbcImplIT");
        assertNotNull(driverDaoJdbcImpl);
        Integer quantityDrivers = driverDaoJdbcImpl.countDrivers();
        assertNotNull(quantityDrivers);
        assertTrue(quantityDrivers > 0);
        assertEquals(Integer.valueOf(3), quantityDrivers);
    }
}


