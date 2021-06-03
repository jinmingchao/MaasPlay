package com.chinaunicom.torn.mcloud.controller;

/**
 * @Author MingChao Jin
 * @Date 2021/6/3 10:28
 * @Description: 区域管理controller
 */

import com.chinaunicom.torn.mcloud.entity.CloudbootAreaEntity;
import com.chinaunicom.torn.mcloud.service.AreaZoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *      区域管理
 *         |______地理区域
 *         |______网络分区
 *         |______业务ip池
 *         |______装机网段
 *         |______管理网段
 *
 */

@Api(value="AreaZoneController", tags = ("区域管理controller"))
@RestController
@RequestMapping("api/area/")
public class AreaZoneController {

    //private static LogEntityFactory logFactory = new LogEntityFactory(AreaZoneController.class);

    @Autowired
    private AreaZoneService areaZoneService;

    @ApiOperation(value = "获取所有应用网段列表 ")
    @GetMapping("/networklist")
    public List<CloudbootAreaEntity> findAllNetWorkList() {
        return this.areaZoneService.findAllNetWorkLst();
    }
}
