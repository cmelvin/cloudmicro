package com.cloudmicro.microservices.genericpubservice;


import org.springframework.web.bind.annotation.*;

@RestController
public class GenericPublisherController {

   @PostMapping("/generic-publish")
   public String publishXML(@RequestBody String xmlData) {
       System.out.println("DATA IN GENERIC:" + xmlData);
       return "Success";
   }
}
