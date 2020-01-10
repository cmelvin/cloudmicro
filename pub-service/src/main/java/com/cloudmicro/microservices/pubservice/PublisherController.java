package com.cloudmicro.microservices.pubservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {


    @Autowired
    private Configuration configuration;

    @GetMapping("/publish")
   public Limits publishXML(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
