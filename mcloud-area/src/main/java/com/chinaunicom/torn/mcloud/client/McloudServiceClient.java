package com.chinaunicom.torn.mcloud.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author MingChao Jin
 * @Date 2021/6/3 10:45
 * @Description: TODO
 */
@FeignClient(value = "mcloud")
public interface McloudServiceClient {

//    @GetMapping("/areaController_1")
//    public String AuthService_1();

//    @GetMapping("/networklist")
//    List<CloudbootAreaEntity> findAllNetWorkLst();
}
