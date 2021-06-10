package com.chinaunicom.torn.mcloud.service.impl;


import com.chinaunicom.torn.mcloud.domain.CloudbootArea;
import com.chinaunicom.torn.mcloud.domain.vo.CloudbootTokenEntity;
import com.chinaunicom.torn.mcloud.mapper.CloudbootAreaMapper;
import com.chinaunicom.torn.mcloud.service.AreaZoneService;
import com.chinaunicom.torn.mcloud.service.BaremetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;


@Service
public class AreaZoneServiceImpl implements AreaZoneService {

    @Autowired
    private BaremetalService baremetalService;

    @Autowired
    private CloudbootAreaMapper cloudBootArea;

    private Map<String, CloudbootTokenEntity> cloudbootTokens;

    public AreaZoneServiceImpl() {
        this.cloudbootTokens = new HashMap<>();
    }

    public boolean createCloudArea(CloudbootArea cloud) {
        if (1 == this.cloudBootArea.insert(cloud)) {


            
            ExecutorService executor = Executors.newFixedThreadPool(2);
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(new Supplier<Integer>() {
                @Override
                public Integer get() {
                    if (cloud.getEnabled() && loginArea(cloud)) {
                        System.out.println(12321);
//                       try {
//                           schedulerService.registerSpecCloudbootAreaScheduler(cloud);
//                       } catch (IOException | ClassNotFoundException e) {
//                           e.printStackTrace();
//                       }
                    }
                    return 3;
                }
            }, executor);
            return true;
        }
        return false;
    }

    @Override
    public List<CloudbootArea> fetchAllCloud() {
        return this.cloudBootArea.selectList(null);
    }

    @Override
    public boolean loginArea(CloudbootArea cloudbootArea) {
        Optional<CloudbootTokenEntity> token = this.baremetalService.loginCloudboot(
                cloudbootArea.getHost(), cloudbootArea.getUsername(), cloudbootArea.getPassword());
        if (!token.isPresent()) {
//            this.logService.error(AuthenticationServiceImpl.logFactory.product()
//                    .who(ServiceRole.PROMOTER).how(LogHow.CALL).what("Cloudboot Login Failed").why("Cannot got Cloudboot token.").build());
            return false;
        }

//        this.logService.info(AuthenticationServiceImpl.logFactory.product()
//                .who(ServiceRole.PROMOTER).how(LogHow.STARTUP).what("Cloudboot Login Success").build());

        token.get().setId(cloudbootArea.getId());
        token.get().setDefaultCloudbootNetworkId(cloudbootArea.getDefaultCloudbootNetworkId());
        this.cloudbootTokens.put(cloudbootArea.getId(), token.get());//Key: 每个cloudboot area 区域ID
        //Value: 每个区域对应的cloudboot area对象, 存map
//        this.cloudbootTokens.forEach( (key, tk) -> {
//
//                System.out.println(key);
//                System.out.println(tk.getToken());
//            System.out.println();
//                }
//        );
        return true;
    }

    @Override
    public boolean updateCloudArea(CloudbootArea area) {
//        this.logService.info(AreaZoneServiceImpl.logFactory.product()
//                .who(ServiceRole.PROMOTER).how(LogHow.UPDATE).what("update ip net  :" + net.toString()).build());
        return 1 == cloudBootArea.updateById(area) ? true : false;

//        try {
//
//            this.cloudBootArea.updateById(area);
//        } catch (Exception e) {
//            this.logService.error(AreaZoneServiceImpl.logFactory.product()
//                    .who(ServiceRole.PROMOTER).how(LogHow.CREATE).what("update failed").why(e.getMessage()).build());
//        }
    }

    @Override
    public boolean deleteCloudArea(CloudbootArea area) {
          return true;
    }


}
