package com.element.hydrogen.controller.web.book;

import cn.hutool.http.server.HttpServerRequest;
import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.book.DonBookInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.service.book.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BookInfoController
 * @Description 图书信息
 * @Author yanyu
 * @Date 2020/11/10 22:26
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/bookInfo")
public class BookInfoController {

    @Autowired
    private BookInfoService bookInfoService;

    public static ResponseJsonConstant res;

    @CrossOrigin
    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public ResponseJson query(@RequestBody DonBookInfoEntity donBookInfoEntity){
        return bookInfoService.query(donBookInfoEntity);
    }

    @CrossOrigin
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ResponseJson insert(HttpServerRequest request, @RequestBody DonBookInfoEntity donBookInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donBookInfoEntity.setOperator("molecule");
        try{
            resJson =bookInfoService.insert(donBookInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseJson update(HttpServerRequest request,@RequestBody DonBookInfoEntity donBookInfoEntity){
        ResponseJson resJson = new ResponseJson();
        donBookInfoEntity.setOperator("molecule");
        try{
            resJson =bookInfoService.update(donBookInfoEntity);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @CrossOrigin
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseJson delete(@RequestBody List<DonBookInfoEntity> donBookInfoEntityList){
        ResponseJson resJson = new ResponseJson();
        try{
            resJson =bookInfoService.delete(donBookInfoEntityList);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_DEL);
        }
        return resJson;
    }

}
