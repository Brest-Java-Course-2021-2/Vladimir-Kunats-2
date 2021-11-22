package com.epam.brest.dao;

import com.epam.brest.model.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
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

@Component
public class DriverDaoJDBCImpl implements DriverDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String SQL_ALL_DRIVER = "select d.driverId, d.firstName, d.lastName, d.distance, d.salary fron driver d order by d.lastName";

    public DriverDaoJDBCImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new namedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Driver> findAll() {
        return namedParameterJdbcTemplate.query(SQL_ALL_DRIVER, DriverRowMapper);
    }

    @Override
    public Integer create(Driver driver) {
        return null;
    }

    @Override
    public Integer update(Driver driver) {
        return null;
    }

    @Override
    public Integer delete(Integer driverId) {
        return null;
    }

    private class DriverRowMapper implements RowMapper<Driver> {
        @Override
        public Driver mapRow(ResultSet resultSet, int i) throws SQLException {
            Driver driver = new Driver();
            driver.setDriverId(resultSet.getInt("driverId"));
            driver.setFirstName(resultSet.getString("firstname"));
            driver.setLastName(resultSet.getString("lastName"));
            driver.setDistance(resultSet.getInt("distance"));
            driver.setSalary(resultSet.getBigDecimal("salary"));
            return driver;

        }
    }
}
