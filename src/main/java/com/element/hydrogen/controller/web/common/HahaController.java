package com.element.hydrogen.controller.web.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanyu
 */
@RestController
public class HahaController {



    @RequestMapping("/yoyo")
    @ResponseBody
    public String getHello() {
        return "hello,niconiconi!";
    }



/*    @RequestMapping(value="/GetIndoorCheckItemEntities",method= RequestMethod.GET)
   // @ApiOperation("获取数据库内容")
    public ArrayList<IndoorCheckItemEntity> GetIndoorCheckItemEntities(){
        return service.GetIndoorCheckItemEntities();
    }*/


}
