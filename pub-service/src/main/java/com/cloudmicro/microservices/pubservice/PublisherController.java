package com.cloudmicro.microservices.pubservice;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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

    @GetMapping("/publish/{xmlData}")
    public DataBean publishXML(@PathVariable String xmlData){
        Optional<Data> data=dataRepository.findById(1000L);

        //String xmlData=data.get().getData().toString();
        //xmlData="Hello World";
        Map<String,String> uriVaraibles =new HashMap<>();
        uriVaraibles.put("xmlData",xmlData);
        String checkUrl="http://localhost:8000/generic-publish/{xmlData}";

        ResponseEntity<DataBean> responseEntity=
                new RestTemplate().getForEntity("http://localhost:8000/generic-publish/{xmlData}",
                DataBean.class,uriVaraibles);


        return new DataBean(responseEntity.getBody().getId(),responseEntity.getBody().getData().toString());

        //return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }

    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException, IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}


   /* @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {

        // Feign - Problem 1
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
                uriVariables);

        CurrencyConversionBean response = responseEntity.getBody();

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
                                                       @PathVariable BigDecimal quantity) {

        CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);

        logger.info("{}", response);

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }*/