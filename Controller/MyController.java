package com.projects.testdm.Controller;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    public String getMessage(){
        return "my controller message";
    }
}