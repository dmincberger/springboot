package com.projects.testdm.Controller;

import com.projects.testdm.model.Pizza;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@RestController
@RequestMapping("/api") // zmiana wejścia do aplikacji, pozostałe adresy będą względem /api
public class PizzaRESTController {

    public PizzaRESTController() {
        System.out.println("pizza REST controller is starting...");
    }

    @RequestMapping("/info")
    public String hello() {
        return "helo REST pizza";
    }

    //zamiast @RequestMapping("/pizza") to samo poniżej, uszczegółowione
    @RequestMapping(
            value = "/pizza",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}

    )

    public Pizza getPizza() {
        return new Pizza("margerita", 30);
    }

    @RequestMapping("/all")
    public ArrayList<Pizza> getAllPizza() {
        return new ArrayList<Pizza>() {{
            add(new Pizza("margerita", 30));
            add(new Pizza("pizza hut", 40));

        }};
    }
}
