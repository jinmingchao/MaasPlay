package com.chinaunicom.torn.mcloud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@TableName("tb_cloudboot_area")
public @Data class CloudbootArea {
    private String id;
    private String name;
    private String host;
    private String username;
    private String password;
    private Integer defaultCloudbootNetworkId;
    private Long syncInstanceInterval;
    private Boolean enabled;
}
