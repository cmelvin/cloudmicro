package com.cloudmicro.microservices.pubservice;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class PublisherController {


    @Autowired
    private Configuration configuration;

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private PubServiceFeignProxy pubServiceFeignProxy;

    @GetMapping("/publish")
    public String publishXML(){
        Optional<Data> data=dataRepository.findById(1000L);

        String xmlData=data.get().getData().toString();
        String checkUrl="http://172.17.0.4:8000/generic-publish";


        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");

        headers.setAll(map);

        Map req_payload = new HashMap();
        req_payload.put("xmlData", xmlData);

        HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
        ResponseEntity<?> response = new RestTemplate().postForEntity(checkUrl, request, String.class);


        return response.getBody().toString();

    }

    @GetMapping("/publish-feign")
    public String publishXMLFeign(){
        Optional<Data> data=dataRepository.findById(1000L);
        String xmlData=data.get().getData().toString();
        String status=pubServiceFeignProxy.publishStatus(xmlData);
        return status;
    }

    @GetMapping("/publish-limits")
    public Limits publishLimits(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }

    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException, IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}


