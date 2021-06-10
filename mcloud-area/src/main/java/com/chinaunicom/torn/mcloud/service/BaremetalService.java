package com.chinaunicom.torn.mcloud.service;

import com.chinaunicom.torn.mcloud.domain.vo.CloudbootTokenEntity;

import java.util.Optional;

/**
 * @Author MingChao Jin
 * @Date 2021/6/7 10:36
 * @Description: TODO
 */
public interface BaremetalService {

    Optional<CloudbootTokenEntity> loginCloudboot(String host, String username, String password);
}
