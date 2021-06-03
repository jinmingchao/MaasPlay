package com.chinaunicom.torn.mcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MingChao Jin
 * @Date 2021/6/2 10:59
 * @Description: TODO
 */

@RestController
public class TestController {

    @GetMapping("/areaController_1")
    public String areaController_1 () {
             return "This is areaContorller_1";
    }
}
