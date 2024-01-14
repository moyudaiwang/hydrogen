package com.element.hydrogen.controller.web.map;

import com.element.hydrogen.dto.map.MapParam;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.service.map.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName MapController
 * @Description 地图Controller
 * @Author yanyu
 * @Date 2024/1/7 4:48
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/map")
public class MapController {

    @Autowired
    private MapService mapService;
    /**
     * 初始化地图菜单
     * @param mapParam
     * @return
     */
    @RequestMapping(value = "/initMapMenu",method = RequestMethod.POST)
    public ResponseJson initMapMenu(@RequestBody MapParam mapParam){
        ResponseJson resJson = mapService.initMapMenu(mapParam);
        return resJson;
    }

    /**
     * 按表名+模块名查询地图点集合
     * @param mapParam
     * @return
     */
    @RequestMapping(value = "/queryMapPoints",method = RequestMethod.POST)
    public ResponseJson queryMapPoints(@RequestBody MapParam mapParam){
        ResponseJson resJson = mapService.queryMapPoints(mapParam);
        return resJson;
    }
}
