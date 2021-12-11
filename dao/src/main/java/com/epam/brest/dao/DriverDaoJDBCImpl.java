package com.epam.brest.dao;

import com.epam.brest.model.Driver;
import com.epam.brest.model.dao.DriverDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.epam.brest.dao.SqlQueries.*;

@Component
public class DriverDaoJDBCImpl implements DriverDao {
    private final Logger logger = LogManager.getLogger(DriverDaoJDBCImpl.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DriverDaoJDBCImpl(final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }



    @Override
    public List<Driver> findAllDrivers() {
        logger.debug("Start:findAllDrivers()");
         return namedParameterJdbcTemplate.query(SQL_ALL_DRIVER, new DriverRowMapper());

    }

    @Override
    public Integer createDriver(Driver driver) {
        logger.debug("Start:createDriver({})", driver);
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("driverLicence",driver.getDriverLicence());
          KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_CREATE_DRIVER, sqlParameterSource, keyHolder);
        return (Integer) keyHolder.getKey();

    }

    @Override
    public Integer updateDriver(Driver driver) {
        logger.debug("Start:updateDriver({})", driver);
        return null;
    }

    @Override
    public Integer deleteDriver(Integer driverId) {
        logger.debug("Start:deleteDriver({})", driverId);
        return null;
    }

    @Override
    public Driver getDriverById(Integer driverId) {
        logger.debug("Start:getDriverById({})", driverId);
        return null;
    }

    @Override
    public Integer countDriver() {
        logger.debug("Start:countDriver({})");
        return null;
    }

    private class DriverRowMapper implements RowMapper<Driver> {
        @Override
        public Driver mapRow(ResultSet resultSet, int i) throws SQLException {
            Driver driver = new Driver();
            driver.setDriverId(resultSet.getInt("driverId"));
            driver.setFirstName(resultSet.getString("firstname"));
            driver.setLastName(resultSet.getString("lastName"));
            driver.setLastName(resultSet.getString("driverLicence"));
            driver.setWorkDate(resultSet.getTimestamp("workDate").toInstant());
            return driver;
        }
    }
}
