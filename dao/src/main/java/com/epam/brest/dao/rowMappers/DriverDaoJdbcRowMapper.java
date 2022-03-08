package com.epam.brest.dao.rowMappers;

import com.epam.brest.model.Driver;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverDaoJdbcRowMapper implements RowMapper<Driver> {

    /**
     * Get driver mapRow.
     *
     * @param resultSet ResultSet.
     * @param i int.
     * @return driver mapRow.
     * @throws SQLException
     */
    @Override
    public Driver mapRow(ResultSet resultSet, int i) throws SQLException {
        Driver driver = new Driver();
        driver.setDriverId(resultSet.getInt("driver_id") );
        driver.setDriverFirstName(resultSet.getString("driver_firstname"));
        driver.setDriverLastName(resultSet.getString("driver_lastname"));
        driver.setDriverWorkDate(resultSet.getTimestamp("driver_workdate").toInstant());
        driver.setDriverLicense(resultSet.getString("driver_license"));
        driver.setDriverSalary(resultSet.getBigDecimal("driver_salary"));
        return driver;
    }
}
