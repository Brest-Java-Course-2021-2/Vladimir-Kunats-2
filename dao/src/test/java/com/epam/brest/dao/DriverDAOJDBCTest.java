package com.epam.brest.dao;

import com.epam.brest.model.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class DriverDAOJDBCTest {
    @InjectMocks
    private DriverDaoJDBCImpl driverDaoJDBC;
    @Mock
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Captor
    private ArgumentCaptor<RowMapper<Driver>> captor;
    @AfterEach
    public void check(){

    }
    @Test
    public void findAllDrivers(){
        //String sql = "select";
        //ReflectionTestUtils.getField(driverDaoJDBC, Class.forName("SQL_ALL_DRIVER"), sql);
        Driver driver = new Driver();
        List<Driver> list = Collections.singletonList(driver);
        Mockito.when(namedParameterJdbcTemplate.query(any(), ArgumentMatchers.< RowMapper<Driver>>any())).thenReturn(list);
        List<Driver> result = driverDaoJDBC.findAllDrivers();
        //Mockito.verify(namedParameterJdbcTemplate).query(sql, captor.capture());
        //RowMapper<Driver> mapper = captor.getValue();
        //Assertions.assertNotNull(mapper);
                Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertSame(driver, result.get(0));
    }
    @Test
    public void getDriverById(){
                int id = 0;
        Driver driver = new Driver();
        Mockito.when(namedParameterJdbcTemplate.queryForObject(any(),
                ArgumentMatchers.<SqlParameterSource>any(),
                ArgumentMatchers.<RowMapper<Driver>>any()))
                .thenReturn(driver);
        Driver result = driverDaoJDBC.getDriverById(id);
        Assertions.assertNotNull(result);
        Assertions.assertSame(driver, result);
    }

}
