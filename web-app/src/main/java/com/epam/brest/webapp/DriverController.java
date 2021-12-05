package com.epam.brest.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DriverController {

    /**
     * Goto drivers list page.
     *
     * @return view name
     */
    @GetMapping(value = "/drivers")
    public final String drivers(Model model) {
        return "drivers";
    }

    /**
     * Goto edit department page.
     *
     * @return view name
     */
    @GetMapping(value = "/driver/{id}")
    public final String gotoEditDriverPage(@PathVariable Integer id, Model model) {
        return "driver";
    }

    /**
     * Goto new driver page.
     *
     * @return view name
     */
    @GetMapping(value = "/driver/add")
    public final String gotoAddDriverPage(Model model) {
        return "driver";
    }
}
