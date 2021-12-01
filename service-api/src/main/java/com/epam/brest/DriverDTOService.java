package com.epam.brest;

import com.epam.brest.model.Driver;

import java.util.List;

public interface DriverDTOService {

    /**
     * Get list of driver Dto.
     *
     * @return list of driver Dto.
     */
    List<Driver> findAllWithAvgSBalance();
}
