package com.cloudmicro.microservices.genericpubservice;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.StringWriter;
import java.io.Writer;

@RestController
public class GenericPublisherController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${server.port}")
    private String serverPort;

   @PostMapping("/generic-publish")
   public String publishXML(@RequestBody String xmlData) {
       System.out.println("DATA IN GENERIC:" + xmlData);
       System.out.println("SERVER PORT:" + serverPort);
       sendToQueue(xmlData);
       return "Success"+":"+serverPort;
   }

    @GetMapping("/generic-publish-get")
    public String publishXML() {

       sendToQueue("Success@Get"+":"+serverPort);
       return "Success@Get"+":"+serverPort;
    }

    public void sendToQueue(String xmlString) {

/*        Writer w = new StringWriter();
        JAXB.marshal(event, w);
        String xmlString =  xmlString = w.toString();*/

        System.out.println("Sending Message");
        System.out.println(xmlString);


        rabbitTemplate.convertAndSend(RabbitConfig.OUTBOUND_QUEUE_NAME, xmlString);

        //send correlation id to audit queue
        rabbitTemplate.convertAndSend(RabbitConfig.OUTBOUND_AUDIT_QUEUE_NAME, (xmlString));
    }
}
