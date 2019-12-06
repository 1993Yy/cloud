package com.yy.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.yy.feign
 * @ClassName: Acontroller
 * @Author: Created By Yy
 * @Date: 2019-12-06 11:39
 */
@RestController
@RefreshScope
public class Acontroller {
    @Value("${name}")
    private String name;

    @Value("${client-name}")
    private String clientName;

    @Autowired
    BFeignClient bFeignClient;

    @GetMapping("/")
    public String test(){
        System.out.println("=====");
        String test = bFeignClient.test();
        System.out.println(test);
        return "a:"+name+"--------------"+clientName+"   b:"+test;
    }
}
