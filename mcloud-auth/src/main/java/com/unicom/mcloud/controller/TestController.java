package com.unicom.mcloud.controller;

import com.unicom.mcloud.client.AreaServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MingChao Jin
 * @Date 2021/6/2 10:59
 * @Description: TODO
 */

@RestController
public class TestController {

    @Autowired
    AreaServiceClient areaServiceClient;

    @GetMapping("/authController_1")
    public String authController_1 () {
        return areaServiceClient.AuthService_1();
    }
}
