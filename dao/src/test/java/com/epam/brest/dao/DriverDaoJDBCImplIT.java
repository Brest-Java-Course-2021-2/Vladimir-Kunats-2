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
        logger.debug("Execute test: findAll()");
        assertNotNull(driverDaoJDBC);
        assertNotNull(driverDaoJDBC.findAll());

    }

    @Test
    void createDriver() {
        logger.debug("Execute test: createDriver()");
        assertNotNull(driverDaoJDBC);
        int driverSizeBefore = driverDaoJDBC.findAll().size();
        Driver driver = new Driver("1AA037164");
        Integer newDriverId = driverDaoJDBC.create(driver);
        assertNotNull(newDriverId);
        assertEquals((int) driverSizeBefore, driverDaoJDBC.findAll().size() - 1);


    }

    @Test
    void tryToCreateDriver() {
        logger.debug("Execute test: tryToCreateDriver()");
        assertNotNull(driverDaoJDBC);
        Driver driver = new Driver("1AA037164");
        assertThrows(DuplicateKeyException.class, () -> {
            driverDaoJDBC.create(driver);
            driverDaoJDBC.create(driver);
        });
    }
    @Test
    void updateDriver() {
        logger.debug("Execute test: updateDriver()");
        List<Driver> drivers = driverDaoJDBC.findAll();
        driverDaoJDBC.update("Petr", "Petrov", "1AA098321", Instant.parse());
        teams = teamDaoJDBC.findAll();
    Team teamSrc = teams.get(0);
    Team teamDst = teamDaoJDBC.getTeamById(teamSrc.getTeamId());
    assertEquals(teamSrc.getTeamName(), teamDst.getTeamName());
    }
    @Test
    void deleteDriver() {
        logger.debug("Execute test: deleteDriver()");
        List<Driver> drivers = driverDaoJDBC.findAll();
        driverDaoJDBC.delete(3);
        assertEquals(driverDaoJDBC.findAll().size(), drivers.size() - 1);
    }
}