package com.projects.testdm.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
    public String getMessage(){
        return "my repository message";
    }
}
