package com.epam.brest.dao;

import com.epam.brest.dao.rowMappers.CarDaoJdbcRowMapper;
import com.epam.brest.model.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.epam.brest.dao.queries.SqlQueriesCar.*;


@Component
public class CarDaoJdbcImpl implements CarDao {


    private final Logger logger = LogManager.getLogger(CarDaoJdbcImpl.class);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public CarDaoJdbcImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    /**
     * Find all cars.
     *
     * @return list of cars.
     */

    @Override
    public List<Car> findAllCars() {
        logger.info("Method findAllCars started");
        return namedParameterJdbcTemplate.query(SQL_CAR_FIND_ALL,
                new CarDaoJdbcRowMapper());
    }

    /**
     * Find car by Id.
     *
     * @param id car Id.
     * @return car.
     */

    @Override
    public Car findCarById(Integer id) {
        logger.info("Method findCarById started");
        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource("carId", id);
        return namedParameterJdbcTemplate.queryForObject(
                SQL_CAR_FIND_BY_ID, sqlParameterSource,
                new CarDaoJdbcRowMapper());
    }

    /**
     * Update car.
     *
     * @param id car id.
     * @param car car.
     * @return number of updated records in the database.
     */

    @Override
    public Integer updateCarById(Integer id, Car car) {
        logger.info("Method updateCarById started");

        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("carId", id)
                .addValue("carModel", car.getCarModel())
                .addValue("carMileage", car.getCarMileAge())
                .addValue("driverId", car.getDriverId());
        return namedParameterJdbcTemplate.update(
                SQL_CAR_UPDATE_BY_ID, sqlParameterSource);
    }
    /**
     * Persist new car.
     *
     * @param car car.
     * @return persisted car id.
     */

    @Override
    public Integer createCar(Car car) {
        logger.info("Method saveCar started");
        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource()
                        .addValue("carModel", car.getCarModel())
                        .addValue("carMileage", car.getCarMileAge())
                        .addValue("driverId", car.getDriverId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_CAR_CREATE,
                sqlParameterSource, keyHolder);
        return (Integer) keyHolder.getKey();
    }
    /**
     * Delete car.
     *
     * @param id car id.
     * @return number of updated records in the database.
     */

    @Override
    public Integer deleteCarById(Integer id) {
        logger.info("Method deleteCarById started");

        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource("carId", id);
        return namedParameterJdbcTemplate.update(
                SQL_CAR_DELETE_BY_ID, sqlParameterSource);
    }

    /**
     * Count cars.
     *
     * @return quantity of the cars.
     */

    @Override
    public Integer countCars() {
        logger.info("Method countCars started");
        return namedParameterJdbcTemplate.queryForObject(
                SQL_CAR_ALL_COUNT, new MapSqlParameterSource(), Integer.class);
    }
}



