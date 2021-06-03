package com.chinaunicom.torn.mcloud.service;

import com.chinaunicom.torn.mcloud.entity.CloudbootAreaEntity;
import com.chinaunicom.torn.mcloud.message.BatchIPMessage;

import java.util.List;

public interface AreaZoneService {

    /**
     * @Description: TODO
     * @Param []
     * @Return java.util.List<com.chinaunicom.torn.mcloud.enetity.CloudbootAreaEntity>
     * @Throw
     * @Author MingChao Jin
     * @Date 2021/6/3 14:09
     */
    List<CloudbootAreaEntity> findAllNetWorkLst();
}
