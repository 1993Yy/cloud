package com.yy.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Package: com.yy.feign
 * @ClassName: BFeignClient
 * @Author: Created By Yy
 * @Date: 2019-12-06 11:29
 */
@FeignClient(name = "cloud-b")
public interface BFeignClient {

    @GetMapping("/")
    String test();

    @Component
    class BB implements BFeignClient{
        @Override
        public String test() {
            return "error";
        }
    }
}
