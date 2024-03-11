package com.opensql.opensql;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    static final String MAIN = "/";
    @RequestMapping(value = MAIN, method = RequestMethod.GET)
    public String homepage() {
        return "home";
    }
}
