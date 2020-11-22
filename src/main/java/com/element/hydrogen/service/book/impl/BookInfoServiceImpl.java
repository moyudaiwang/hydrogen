package com.element.hydrogen.service.book.impl;

import com.element.hydrogen.entity.book.BookInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.mapper.book.BookInfoMapper;
import com.element.hydrogen.service.book.BookInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookInfoServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2020/11/10 22:24
 * @Version 1.0
 */
@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    public BookInfoMapper bookInfoMapper;

    /**
     * 分页查询用户列表
     * @param bookInfoEntity
     * @return
     */
    @Override
    public PageInfo<BookInfoEntity> queryBookInfoPage(BookInfoEntity bookInfoEntity) {
        PageHelper.startPage(bookInfoEntity.getPageNum(), bookInfoEntity.getPageSize());
        List<BookInfoEntity> bookInfoEntityList = bookInfoMapper.queryBookInfoPage(bookInfoEntity);
        PageInfo<BookInfoEntity> pageInfo =new PageInfo<BookInfoEntity>(bookInfoEntityList);
        System.out.println("user-----------"+bookInfoEntityList);
        System.out.println("page------------"+pageInfo);
        return pageInfo;
    }

    @Override
    public ResponseJson insertBookInfo(BookInfoEntity bookInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try{
            bookInfoMapper.insertBookInfo(bookInfoEntity);
            resJson.setCode("200");
            resJson.setStatus("true");
            resJson.setMessage("新增成功");
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMessage("新增失败");
        }
        return resJson;
    }

    @Override
    public ResponseJson updateBookInfo(BookInfoEntity bookInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try{
            bookInfoMapper.updateBookInfo(bookInfoEntity);
            resJson.setCode("200");
            resJson.setStatus("true");
            resJson.setMessage("修改成功");
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMessage("修改失败");
        }
        return resJson;
    }

    @Override
    public ResponseJson deleteBookInfo(BookInfoEntity bookInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try{
            bookInfoMapper.deleteBookInfo(bookInfoEntity);
            resJson.setCode("200");
            resJson.setStatus("true");
            resJson.setMessage("删除成功");
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMessage("删除失败");
        }
        return resJson;
    }

    @Override
    public ResponseJson deleteBatchBookInfo(String donBookInfoIds) {
        ResponseJson resJson = new ResponseJson();
        try{
            String [] donBookInfoIdList= donBookInfoIds.split(",");
            int deleteBatchNum = bookInfoMapper.deleteBatchBookInfo(donBookInfoIdList);
            resJson.setCode("200");
            resJson.setStatus("true");
            resJson.setMessage("删除成功："+"删除"+deleteBatchNum+"条");
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMessage("删除失败");
        }
        return resJson;
    }
}
