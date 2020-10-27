package com.element.hydrogen.controller.web.common;

import com.element.hydrogen.entity.common.IndoorCheckItemEntity;
import com.element.hydrogen.service.common.impl.ConService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;

public class ConController {

    @Resource
    private ConService service;
    @RequestMapping(value="/GetIndoorCheckItemEntities",method= RequestMethod.GET)
    //@ApiOperation("获取数据库内容")
    public ArrayList<IndoorCheckItemEntity> GetIndoorCheckItemEntities(){
        return service.GetIndoorCheckItemEntities();
    }
}
