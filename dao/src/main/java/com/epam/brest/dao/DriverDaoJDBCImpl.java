package com.epam.brest.dao;

import com.epam.brest.model.Driver;
import com.epam.brest.model.dao.DriverDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Component
public class DriverDaoJDBCImpl implements DriverDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String SQL_ALL_DRIVER = "select d.firstName, d.lastName, d.workDate from driver d order by d.lastName";
    private final String SQL_CREATE_DRIVER = "insert into driver(firstName) values (:firstName)";

    public DriverDaoJDBCImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Driver> findAll() {
         return namedParameterJdbcTemplate.query(SQL_ALL_DRIVER, new DriverRowMapper());

    }

    @Override
    public Integer create(Driver driver) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource("firstname",driver.getFirstName());
          KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_CREATE_DRIVER, sqlParameterSource, keyHolder);
        return (Integer) keyHolder.getKey();

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
            driver.setWorkDate(resultSet.getTimestamp("workDate").toInstant());
            return driver;
        }
    }
}
