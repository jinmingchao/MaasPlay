package com.chinaunicom.torn.mcloud.service;

import com.chinaunicom.torn.mcloud.domain.CloudbootArea;

import java.util.List;

public interface AreaZoneService {

    boolean createCloudArea(CloudbootArea cloud);

    List<CloudbootArea> fetchAllCloud();

    boolean loginArea(CloudbootArea cloudbootArea);

    boolean updateCloudArea(CloudbootArea area);

    boolean deleteCloudArea(CloudbootArea area);
}
