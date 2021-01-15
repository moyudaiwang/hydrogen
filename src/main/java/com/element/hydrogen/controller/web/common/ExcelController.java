package com.element.hydrogen.controller.web.common;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.service.common.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName ExcelController
 * @Description TODO
 * @Author yanyu
 * @Date 2020/12/20 13:21
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    /**
     * 解析+导入
     * @param excelFile
     * @param module
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/imports",method = RequestMethod.POST)
    public ResponseJson imports(@RequestParam("excelFile")MultipartFile excelFile, String module) throws IOException{
        ResponseJson resJson = new ResponseJson();
        try{
            resJson =excelService.imports(excelFile,module);
            System.out.println(resJson);
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMsg("导入失败");
        }
        return resJson;
    }

    /**
     * 解析
     * @param excelFile
     * @param module
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/analyze",method = RequestMethod.POST)
    public ResponseJson analyze(@RequestParam("multipartFiles")MultipartFile[] multipartFiles, String module){
        ResponseJson resJson = new ResponseJson();

        try{

            //判断file数组不能为空并且长度大于0
            if(multipartFiles != null && multipartFiles.length > 0) {
                //循环获取file数组中得文件
                for (int i = 0; i < multipartFiles.length; i++) {
                    MultipartFile file = multipartFiles[i];
                    //保存文件
                    if (!file.isEmpty()) {
                        String n = file.getOriginalFilename();
                        System.out.println("nnnnnnnn---"+n);
                        resJson =excelService.analyze(file,module);
                        System.out.println(resJson);
                    }
                }
            }

        }catch (Exception e){
            System.out.println("eeee----"+e);
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMsg("导入失败");
        }
        return resJson;
    }

    /**
     * 异步导入
     * @param excelFile
     * @param module
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/asyncImport",method = RequestMethod.POST)
    public ResponseJson asyncImport(@RequestParam("excelFile")MultipartFile excelFile, String module, String id) throws IOException{
        ResponseJson resJson = new ResponseJson();
        ResponseJson dtoJson = new ResponseJson();
        try{
            dtoJson =excelService.imports(excelFile,module);
            resJson =excelService.asyncImport(dtoJson,id);
            System.out.println(resJson);
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMsg("导入失败");
        }
        return resJson;
    }

}
