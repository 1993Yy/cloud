package com.yy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class BApplication {

    public static void main(String[] args) {
        SpringApplication.run(BApplication.class, args);
    }

    @Value("${name}")
    private String name;

    @Value("${client-name}")
    private String clientName;

    @GetMapping("/")
    public String test() {
        System.out.println(LocalDateTime.now()+"fdfdf");
        try {
            TimeUnit.SECONDS.sleep(58);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testst");
        return name+"--------------"+clientName;
    }
}
