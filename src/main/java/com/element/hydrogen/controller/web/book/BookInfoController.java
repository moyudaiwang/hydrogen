package com.element.hydrogen.controller.web.book;

import com.element.hydrogen.entity.book.BookInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.service.book.BookInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @ClassName BookInfoController
 * @Description TODO
 * @Author yanyu
 * @Date 2020/11/10 22:26
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/bookInfo")
public class BookInfoController {

    @Autowired
    private BookInfoService bookInfoService;

    /**
     * 分页查询图书列表
     * @param bookInfoEntity
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/queryBookInfoPage",method = RequestMethod.POST)
    public PageInfo<BookInfoEntity> queryBookInfoPage(@RequestBody BookInfoEntity bookInfoEntity){
        PageInfo<BookInfoEntity> pageInfo = new PageInfo<BookInfoEntity>();
        PageHelper.startPage(bookInfoEntity.getPageNum(), bookInfoEntity.getPageSize());
        pageInfo =bookInfoService.queryBookInfoPage(bookInfoEntity);
        return pageInfo;
    }

    /**
     * 新增图书信息
     * @param bookInfoEntity
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/insertBookInfo",method = RequestMethod.POST)
    public ResponseJson insertBookInfo(@RequestBody BookInfoEntity bookInfoEntity){
        ResponseJson resJson = new ResponseJson();
        bookInfoEntity.setOperator("molecule");
        try{
            resJson =bookInfoService.insertBookInfo(bookInfoEntity);
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMsg("新增失败");
        }
        return resJson;
    }
    /**
     * 修改图书信息
     * @param bookInfoEntity
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/updateBookInfo",method = RequestMethod.POST)
    public ResponseJson updateBookInfo(@RequestBody BookInfoEntity bookInfoEntity){
        ResponseJson resJson = new ResponseJson();
        bookInfoEntity.setOperator("molecule");
        try{
            resJson =bookInfoService.updateBookInfo(bookInfoEntity);
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMsg("修改失败");
        }
        return resJson;
    }
    /**
     * 删除图书信息
     * @param bookInfoEntity
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteBookInfo",method = RequestMethod.POST)
    public ResponseJson deleteBookInfo(@RequestBody BookInfoEntity bookInfoEntity){
        ResponseJson resJson = new ResponseJson();
        bookInfoEntity.setOperator("molecule");
        try{
            resJson =bookInfoService.deleteBookInfo(bookInfoEntity);
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMsg("删除失败");
        }
        return resJson;
    }
    /**
     * 批量删除图书信息
     * @param donBookInfoIds
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteBatchBookInfo",method = RequestMethod.POST)
    public ResponseJson deleteBatchBookInfo(@RequestParam String donBookInfoIds) throws UnsupportedEncodingException {
        ResponseJson resJson = new ResponseJson();
        try{
            resJson =bookInfoService.deleteBatchBookInfo(donBookInfoIds);
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMsg("删除失败");
        }
        return resJson;
    }

}
