package com.chinaunicom.torn.mcloud.controller;

/**
 * @Author MingChao Jin
 * @Date 2021/6/3 10:28
 * @Description: 区域管理controller
 */

import com.chinaunicom.torn.mcloud.domain.CloudbootArea;
import com.chinaunicom.torn.mcloud.service.AreaZoneService;
import common.resultgenerator.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

//@Api(value="AreaZoneController", tags = ("区域管理controller"))
@RestController
@RequestMapping("api/area/")
public class AreaZoneController {

    //private static LogEntityFactory logFactory = new LogEntityFactory(AreaZoneController.class);

    @Autowired
    private AreaZoneService areaZoneService;

    //@ApiOperation(value = "更新cloudArea*")
    @PostMapping(path="login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String loginCloudBoot(@RequestBody CloudbootArea cloudbootArea) {
        if (cloudbootArea.getEnabled() && this.areaZoneService.loginArea(cloudbootArea)){
            return "ok";
        }
        return  "error";
    }

//    @ApiOperation(value = "获取所有 ")
    @GetMapping("fetch-cloud/list")
    public Result<List<CloudbootArea>> fetchAllCloud() {
        List<CloudbootArea> result = this.areaZoneService.fetchAllCloud();
        if(null == result) {
            return null;
        }
        return Result.success(result);
        //return result;
    }

    //@ApiOperation(value = "创建cloudArea")
    @PostMapping(path="post-area", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String createCloudArea(@RequestBody CloudbootArea area) {
        //this.loggerService.operationLog(AreaZoneController.logFactory.product().how("webapi").what("/api/area/post-area").build());
        if(this.areaZoneService.createCloudArea(area)){
            return "ok";
        };
        return "error";
    }

    //@ApiOperation(value = "更新cloudArea*")
    @PutMapping(path="/update-area", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String updateCloudArea(@RequestBody CloudbootArea area) {
        //this.loggerService.operationLog(AreaZoneController.logFactory.product().how("webapi").what("/api/area/put-area").build());
        if(areaZoneService.updateCloudArea(area))
            return "ok";
        return "error";
    }

    //@ApiOperation(value = "删除cloudArea* ")
    @DeleteMapping(path="/delete-area/{areaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String deleteCloudArea(@PathVariable String areaId) {
        //this.loggerService.operationLog(AreaZoneController.logFactory.product().how("webapi").what("/api/area/delete-area/" + areaId).build());

        CloudbootArea area = new CloudbootArea();
        area.setId(areaId);
        this.areaZoneService.deleteCloudArea(area);
        return "ok";
    }

}
