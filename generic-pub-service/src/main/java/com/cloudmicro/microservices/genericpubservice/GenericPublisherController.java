package com.cloudmicro.microservices.genericpubservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericPublisherController {


    @GetMapping("/generic-publish/{xmlData}")
   public DataBean publishXML(@PathVariable String xmlData){
        System.out.println("DATA:"+xmlData);
        return new DataBean(10L,xmlData);


  /*      return "<?xml version=\"1.0\"?>\n" +
                "<catalog>\n" +
                "   <book id=\"bk101\">\n" +
                "      <author>Gambardella, Matthew</author>\n" +
                "      <title>XML Developer's Guide</title>\n" +
                "      <genre>Computer</genre>\n" +
                "      <price>44.95</price>\n" +
                "      <publish_date>2000-10-01</publish_date>\n" +
                "      <description>An in-depth look at creating applications \n" +
                "      with XML.</description>\n" +
                "   </book>" +
                "</catalog>";*/
    }
}
