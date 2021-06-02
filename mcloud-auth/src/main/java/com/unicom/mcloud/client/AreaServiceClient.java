package com.unicom.mcloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author MingChao Jin
 * @Date 2021/6/2 16:23
 * @Description: TODO
 */
@FeignClient(value = "area")
public interface AreaServiceClient {

      @GetMapping("/areaController_1")
      public String AuthService_1();
}
