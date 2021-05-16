package com.element.hydrogen.controller.web.common;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.service.common.DataService;
import com.element.hydrogen.service.common.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName DataController
 * @Description 数据层
 * @Author yanyu
 * @Date 2021/4/12 23:46
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/data")
public class DataController {

    @Autowired
    private DataService dataService;

    /**
     * 上传Excel，生成创建表结构SQL
     * @param excelFiles
     * @param module
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/createTable",method = RequestMethod.POST)
    public ResponseJson imports(@RequestParam("excelFiles") MultipartFile[] excelFiles, String module) throws IOException{
        ResponseJson resJson = new ResponseJson();
        try{
            resJson =dataService.createTable(excelFiles,module);
            System.out.println("resJson-------"+resJson);
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMsg("导入失败");
        }
        return resJson;
    }




}
