package com.epam.brest.web_app.validators;

import com.epam.brest.model.Driver;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import static com.epam.brest.model.constants.DriverConstants.*;

public class DriverValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Driver.class.equals(clazz);
    }
    //public static final int DRIVER_FIRSTNAME_SIZE = 50;
    //public static final int DRIVER_LASTNAME_SIZE = 50;
    //public static final int DRIVER_LICENSE_SIZE = 9;
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "driverFirstName", "driverFirstName.empty");
        Driver driver = (Driver) target;

        if (StringUtils.hasLength(driver.getDriverFirstName())
                && driver.getDriverFirstName().length() > DRIVER_FIRSTNAME_SIZE) {
            errors.rejectValue("driverLastName", "driverLastName.maxSize");
        }
        if (StringUtils.hasLength(driver.getDriverLastName())
                && driver.getDriverLastName().length() > DRIVER_LASTNAME_SIZE) {
            errors.rejectValue("driverFirstName", "driverLastName.maxSize");
        }
        if (StringUtils.hasLength(driver.getDriverLicense())
                && driver.getDriverLicense().length() > DRIVER_LICENSE_SIZE) {
            errors.rejectValue("driverLicense", "driverLicense.maxSize");
        }
    }
}
