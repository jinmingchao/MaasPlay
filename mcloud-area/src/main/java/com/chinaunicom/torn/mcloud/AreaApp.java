package com.chinaunicom.torn.mcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author MingChao Jin
 * @Date 2021/6/2 10:55
 * @Description: mcloud-area启动项
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.chinaunicom.torn.mcloud.mapper")
public class AreaApp {
    public static void main(String[] args) {
        SpringApplication.run(AreaApp.class,args);
    }
}
