package com.epam.brest.dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-jdbc-conf.xml"})
//@Transactional
//@Rollback
class DriverDaoJDBCImplTest {
    DriverDaoJDBCImpl driverDaoJDBCImpl;

    public DriverDaoJDBCImplTest(@Autowired DriverDaoJDBCImpl driverDaoJDBCImpl) {
        this.driverDaoJDBCImpl = driverDaoJDBCImpl;
    }

    @Test
    void findAll() {
        assertNotNull(driverDaoJDBCImpl);
        assertNotNull(driverDaoJDBCImpl.findAll());
            }
            @Test
    void create(){
                assertNotNull(driverDaoJDBCImpl);
                Integer driverSizeBefore = DriverDaoJDBCImpl.findAll().size();
                Driver driver = new Driver(firstname"Vasia");
                DriverDAOJDBC.create(driver);
                Integer

            }
}