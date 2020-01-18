package com.cloudmicro.microservices.genericpubservice;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class GenericPublisherController {

    @Value("${server.port}")
    private String serverPort;

   @PostMapping("/generic-publish")
   public String publishXML(@RequestBody String xmlData) {
       System.out.println("DATA IN GENERIC:" + xmlData);
       System.out.println("SERVER PORT:" + serverPort);
       return "Success"+":"+serverPort;
   }
}
