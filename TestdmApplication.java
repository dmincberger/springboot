package com.projects.testdm;

import com.projects.testdm.model.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TestdmApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(TestdmApplication.class, args);
        var m = context.getBean(Message.class);
        System.out.println(m.getMessage());
    }
}
