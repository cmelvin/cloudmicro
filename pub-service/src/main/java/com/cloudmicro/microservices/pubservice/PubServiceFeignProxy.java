package com.cloudmicro.microservices.pubservice;

import feign.Headers;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@FeignClient(name="generic-pub-service", url = "172.17.0.5:8000")
//@FeignClient(name="generic-pub-service")
@RibbonClient(name="generic-pub-service")
public interface PubServiceFeignProxy {

    @PostMapping("/generic-publish")
    @Headers("Content-Type: application/json")
    String publishStatus(@RequestBody String xmlData);
}
