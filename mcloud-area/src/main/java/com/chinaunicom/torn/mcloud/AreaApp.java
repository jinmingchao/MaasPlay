package com.chinaunicom.torn.mcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author MingChao Jin
 * @Date 2021/6/2 10:55
 * @Description: mcloud-area启动项
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClient
public class AreaApp {
    public static void main(String[] args) {
        SpringApplication.run(AreaApp.class,args);
    }
}
