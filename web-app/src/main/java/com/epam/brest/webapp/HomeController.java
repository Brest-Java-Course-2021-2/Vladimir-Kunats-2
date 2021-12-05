package com.epam.brest.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Root controller.
 */

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String defaultPageRedirect() {
        return "redirect:hello";
    }
}

