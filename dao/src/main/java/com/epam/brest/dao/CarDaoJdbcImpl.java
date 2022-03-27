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
        logger.info("Method findAllCars started in class CarDaoJdbcImpl");
        return namedParameterJdbcTemplate.query(SQL_CAR_FIND_ALL,
                new CarDaoJdbcRowMapper());
    }

    /**
     * Find car by Id.
     *
     * @param carId Integer.
     * @return car.
     */

    @Override
    public Car findCarById(Integer carId) {
        logger.info("Method findCarById started in class CarDaoJdbcImpl");
        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource("carId", carId);
        return namedParameterJdbcTemplate.queryForObject(
                SQL_CAR_FIND_BY_ID, sqlParameterSource,
                new CarDaoJdbcRowMapper());
    }

    /**
     * Update car.
     *
     * @param carId Integer.
     * @param car car.
     * @return number of updated records in the database.
     */

    @Override
    public Integer updateCarById(Integer carId, Car car) {
        logger.info("Method updateCarById started in class CarDaoJdbcImpl");
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("carId", carId)
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
        logger.info("Method saveCar started in class CarDaoJdbcImpl ");
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
     * @param carId Integer.
     * @return number of updated records in the database.
     */

    @Override
    public Integer deleteCarById(Integer carId) {
        logger.info("Method deleteCarById started in class CarDaoJdbcImpl");
        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource("carId", carId);
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
        logger.info("Method countCars started in class CarDaoJdbcImpl");
        return namedParameterJdbcTemplate.queryForObject(
                SQL_CAR_ALL_COUNT, new MapSqlParameterSource(), Integer.class);
    }
}



