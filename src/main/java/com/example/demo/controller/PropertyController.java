package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {
    //leer el property usando Environment Object
    @Autowired
    private Environment env;

    @GetMapping("property")
    public String getPropertyValue(@RequestParam("key") String key){
        String returnValue = "No value";
        String keyValue = env.getProperty(key);
        if(keyValue!=null && !keyValue.isEmpty()){
            returnValue=keyValue;
        }
        return returnValue;
    }

    //leer property usando @Value
    @Value("${description}")
    private String descriptionProperty;

    @GetMapping("valueproperty")
    public String getValue(){
        return descriptionProperty;
    }

}
