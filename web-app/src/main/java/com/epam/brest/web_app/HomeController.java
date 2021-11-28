package com.epam.brest.web_app;

    /**
     * Root controller.
     */
    public class HomeController {

        @GetMapping(value = "/")
        public String defaultPageRedirect() {
            return "redirect:departments";
        }
    }

