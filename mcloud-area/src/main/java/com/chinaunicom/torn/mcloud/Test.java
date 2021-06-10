package com.chinaunicom.torn.mcloud;

import com.chinaunicom.torn.mcloud.domain.CloudbootArea;
import com.chinaunicom.torn.mcloud.mapper.CloudbootAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author MingChao Jin
 * @Date 2021/6/4 11:20
 * @Description: TODO
 */

public class Test {

    @Autowired
    private static CloudbootAreaMapper CloudbootArea;

    public static void main(String[] args) {
        System.out.println(("----- selectAll method test ------"));
        System.out.println(CloudbootArea);
        List<com.chinaunicom.torn.mcloud.domain.CloudbootArea> userList = CloudbootArea.selectList(null);
        for (com.chinaunicom.torn.mcloud.domain.CloudbootArea cloudbootArea : userList) {
            System.out.println(cloudbootArea.toString());
        }
    }


}
