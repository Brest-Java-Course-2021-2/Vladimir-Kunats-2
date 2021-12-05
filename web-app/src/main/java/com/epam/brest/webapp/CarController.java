package com.epam.brest.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CarController {
    /**
     * Goto employees list page.
     *
     * @return view name
     */
    @GetMapping(value = "/cars")
    public final String cars(Model model) {
        return "cars";
    }

    /**
     * Goto edit employee page.
     *
     * @return view name
     */
    @GetMapping(value = "/car/{id}")
    public final String gotoEditCarPage(@PathVariable Integer id, Model model) {
        return "employee";
    }

    /**
     * Goto new employee page.
     *
     * @return view name
     */
    @GetMapping(value = "/car/add")
    public final String gotoAddCarPage(){
        return "car";
    }
}