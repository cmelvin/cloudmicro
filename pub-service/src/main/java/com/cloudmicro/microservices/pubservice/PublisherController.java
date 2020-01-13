package com.cloudmicro.microservices.pubservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class PublisherController {


    @Autowired
    private Configuration configuration;

    @Autowired
    private DataRepository dataRepository;

    @GetMapping("/publish")
   public ResponseEntity<Data> publishXML(){
        Optional<Data> data=dataRepository.findById(1000L);

        String xmlData=data.get().getData().toString();
        Map<String,String> uriVaraibles =new HashMap<>();
        return new RestTemplate().getForEntity("http://localhost:8000/generic-publish/{xmlData}",Data.class,uriVaraibles);

        //return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }
}
