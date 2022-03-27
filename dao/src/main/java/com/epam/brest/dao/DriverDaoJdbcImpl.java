package com.epam.brest.dao;

import com.epam.brest.dao.rowMappers.DriverDaoJdbcRowMapper;
import com.epam.brest.model.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.epam.brest.dao.queries.SqlQueriesDriver.*;

@Component
public class DriverDaoJdbcImpl implements DriverDao {

    private final Logger logger = LogManager.getLogger(DriverDaoJdbcImpl.class);

    /**
     * Field namedParameterJdbcTemplate.
     */

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * Constructor.
     *
     * @param namedParameterJdbcTemplate namedParameterJdbcTemplate.
     */

    public DriverDaoJdbcImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * Find all drivers.
     *
     * @return list of drivers.
     */

    @Override
    public List<Driver> findAllDrivers() {
        logger.info("Method findAllDrivers started in class DriverDaoJdbcImpl");
        return namedParameterJdbcTemplate.query(
                SQL_DRIVER_FIND_ALL, new DriverDaoJdbcRowMapper());
    }

    /**
     * Find driver by Id.
     *
     * @param driverId Integer.
     * @return driver.
     */

    @Override
    public Driver findDriverById(final Integer driverId) {
        logger.info("Method findDriverById started in class DriverDaoJdbcImpl");
        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource("driverId", driverId);
        return namedParameterJdbcTemplate.queryForObject(
                SQL_DRIVER_FIND_BY_ID, sqlParameterSource, new DriverDaoJdbcRowMapper());
    }

    /**
     * Create new driver.
     *
     * @param driver driver.
     * @return persisted driver id.
     */

    @Override
    public Integer createDriver(final Driver driver) {
        logger.info("Method createDriver started in class DriverDaoJdbcImpl");
        if (!DriverIsUnique(driver.getDriverLicense())) {
            logger.info("Driver with this driverLicense already exists!!!");}
        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource()
                        .addValue("driverFirstName", driver.getDriverFirstName())
                        .addValue("driverLastName", driver.getDriverLastName())
                        .addValue("driverWorkDate", driver.getDriverWorkDate())
                        .addValue("driverLicense", driver.getDriverLicense())
                        .addValue("driverSalary", driver.getDriverSalary());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_DRIVER_CREATE, sqlParameterSource, keyHolder);
        return (Integer) keyHolder.getKey();
    }

    /**
     * Update driver.
     *
     * @param id driver id.
     * @param driver driver.
     * @return number of updated driver in the database.
     */

    @Override
    public Integer updateDriverById(Integer id, Driver driver) {
        logger.info("Method updateDriverById started in class DriverDaoJdbcImpl");
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("driverId", id)
                .addValue("driverFirstName", driver.getDriverFirstName())
                .addValue("driverLastName", driver.getDriverLastName())
                .addValue("driverWorkDate", driver.getDriverWorkDate())
                .addValue("driverLicense", driver.getDriverLicense())
                .addValue("driverSalary", driver.getDriverSalary());
        return namedParameterJdbcTemplate.update(
                SQL_DRIVER_UPDATE_BY_ID, sqlParameterSource);
    }

    /**
     * Delete driver.
     *
     * @param driverId Integer.
     * @return number of updated records in the database.
     */

    @Override
    public Integer deleteDriverById(Integer driverId) {
        logger.info("Method deleteDriverById started in class DriverDaoJdbcImpl");
        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource("driverId", driverId);
        return namedParameterJdbcTemplate.update(SQL_DRIVER_DELETE_BY_ID,
                sqlParameterSource);
    }
    /**
     * Count drivers.
     *
     * @return count of records.
     */

    @Override
    public Integer countDrivers() {
        logger.info("Method countDrivers started in class DriverDaoJdbcImpl");
        return namedParameterJdbcTemplate.queryForObject(
                SQL_DRIVER_COUNT, new MapSqlParameterSource(), Integer.class);
    }

    /**
     * Get boolean value.
     *
     * @return boolean value.
     */

    private boolean DriverIsUnique(String driverLicense) {
        logger.info("Method DriverIsUnique started in class DriverDaoJdbcImpl");
        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource("driverLicense", driverLicense);
        return namedParameterJdbcTemplate.queryForObject(
                SQL_DRIVER_UNIQUE_LICENSE, sqlParameterSource, Integer.class) == 0;
    }
}
