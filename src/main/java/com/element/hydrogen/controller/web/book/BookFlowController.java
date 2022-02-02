package com.element.hydrogen.controller.web.book;

import cn.hutool.http.server.HttpServerRequest;
import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.book.DonBookFlowEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.service.book.BookFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BookFlowController
 * @Description 图书流动信息
 * @Author yanyu
 * @Date 2022-02-01 05:49:45
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/bookFlow")
public class BookFlowController {

    @Autowired
    private BookFlowService bookFlowService;

    public static ResponseJsonConstant res;

    @CrossOrigin
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResponseJson query(@RequestBody DonBookFlowEntity donBookFlowEntity){
        return bookFlowService.query(donBookFlowEntity);
    }

    @CrossOrigin
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseJson insert(HttpServerRequest request, @RequestBody DonBookFlowEntity donBookFlowEntity){
        ResponseJson resJson = new ResponseJson();
        donBookFlowEntity.setOperator("molecule");
        try{
            resJson =bookFlowService.insert(donBookFlowEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseJson update(HttpServerRequest request,@RequestBody DonBookFlowEntity donBookFlowEntity){
        ResponseJson resJson = new ResponseJson();
        donBookFlowEntity.setOperator("molecule");
        try{
            resJson =bookFlowService.update(donBookFlowEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseJson delete(@RequestBody List<DonBookFlowEntity> donUserInfoEntityList){
        ResponseJson resJson = new ResponseJson();
        try{
            resJson =bookFlowService.delete(donUserInfoEntityList);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_DEL);
        }
        return resJson;
    }
}
