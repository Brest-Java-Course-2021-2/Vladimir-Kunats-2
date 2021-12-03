package com.epam.brest.dao;

import com.epam.brest.model.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-jdbc-conf.xml"})
@Transactional
@Rollback
class DriverDaoJDBCImplIT {
    private final Logger logger = LogManager.getLogger(DriverDaoJDBCImplIT.class);

    DriverDaoJDBCImpl driverDaoJDBC;

    public DriverDaoJDBCImplIT(@Autowired DriverDaoJDBCImpl driverDaoJDBCImpl) {
        this.driverDaoJDBC = (DriverDaoJDBCImpl) driverDaoJDBC;
    }

    @Test
    void findAllDriver() {
        logger.debug("Execute test: findAllDrivers()");
        assertNotNull(driverDaoJDBC);
        assertNotNull(driverDaoJDBC.findAllDrivers());

    }

    @Test
    void createDriver() {
        logger.debug("Execute test: createDriver()");
        assertNotNull(driverDaoJDBC);
        int driverSizeBefore = driverDaoJDBC.findAllDrivers().size();
        Driver driver = new Driver("1AA037164");
        Integer newDriverId = driverDaoJDBC.createDriver(driver);
        assertNotNull(newDriverId);
        assertEquals((int) driverSizeBefore, driverDaoJDBC.findAllDrivers().size() - 1);


    }

    @Test
    void tryToCreateDriver() {
        logger.debug("Execute test: tryToCreateDriver()");
        assertNotNull(driverDaoJDBC);
        Driver driver = new Driver("1AA037164");
        assertThrows(DuplicateKeyException.class, () -> {
            driverDaoJDBC.createDriver(driver);
            driverDaoJDBC.createDriver(driver);
        });
    }
    @Test
    void updateDriver() {
        logger.debug("Execute test: updateDriver()");
        List<Driver> drivers = driverDaoJDBC.findAllDrivers();
        driverDaoJDBC.updateDriver(new Driver("1AA678876"));
        drivers = driverDaoJDBC.findAllDrivers();
    Driver driverSrc = drivers.get(0);
    Driver driverDst = driverDaoJDBC.getDriverById(driverSrc.getDriverId());
    assertEquals(driverSrc.getDriverId(), driverDst.getDriverId());
    }
    @Test
    void deleteDriver() {
        logger.debug("Execute test: deleteDriver()");
        List<Driver> drivers = driverDaoJDBC.findAllDrivers();
        driverDaoJDBC.deleteDriver(3);
        assertEquals(driverDaoJDBC.findAllDrivers().size(), drivers.size() - 1);
    }
    @Test
    void countDriver() {
        logger.debug("Execute test: countDriver()");
        List<Driver> drivers = driverDaoJDBC.findAllDrivers();
        driverDaoJDBC.deleteDriver(3);
        assertEquals(driverDaoJDBC.findAllDrivers().size(), drivers.size() - 1);
    }
}