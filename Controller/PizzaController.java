package com.projects.testdm.Controller;

import com.projects.testdm.model.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
@Controller
@ResponseBody
public class PizzaController {

    public PizzaController() {
        System.out.println("pizza controller is starting...");
    }

    @RequestMapping("/info")

    public String hello() {
        return "hello pizza";
    }

    @RequestMapping("/pizza")
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
