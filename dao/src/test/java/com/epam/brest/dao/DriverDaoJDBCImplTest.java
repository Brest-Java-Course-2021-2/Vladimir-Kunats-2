package com.epam.brest.dao;

import com.epam.brest.model.Driver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-jdbc-conf.xml"})
@Transactional
@Rollback
class DriverDaoJDBCImplTest {
    DriverDaoJDBCImpl driverDaoJDBC;

    public DriverDaoJDBCImplTest(@Autowired DriverDaoJDBCImpl driverDaoJDBCImpl) {
        this.driverDaoJDBC = (DriverDaoJDBCImpl)driverDaoJDBC ;
    }

    @Test
    void findAll() {
        assertNotNull(driverDaoJDBC);
        assertNotNull(driverDaoJDBC.findAll());

            }
            @Test
    void create(){
                assertNotNull(driverDaoJDBC);
                int driverSizeBefore = driverDaoJDBC.findAll().size();
                Driver driver = new Driver(firstName:"VALERA");
                Integer newDriverId = driverDaoJDBC.create(driver);
                assertNotNull(newDriverId);
                assertEquals((int)driverSizeBefore, driverDaoJDBC.findAll().size() - 1);


            }
    void tryToCreateDrivers(){
        assertNotNull(driverDaoJDBC);
        Driver driver = new Driver(firstName:"IVAN");
        assertThrows(DuplicateKeyException.class, () -> {
            driverDaoJDBC.create(driver);
            driverDaoJDBC.create(driver);
        });


    }
}