package com.element.hydrogen.dto.map;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName MapParam
 * @Description 地图入参
 * @Author yanyu
 * @Date 2024/1/7 4:56
 * @Version 1.0
 */
@Data
public class MapParam implements Serializable {
    //表名
    private String table;
    //模块
    private String module;

}
