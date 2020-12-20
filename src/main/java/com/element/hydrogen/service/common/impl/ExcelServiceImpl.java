package com.element.hydrogen.service.common.impl;

import com.element.hydrogen.constant.common.ExcelConstant;
import com.element.hydrogen.entity.book.BookInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.mapper.book.BookInfoMapper;
import com.element.hydrogen.service.common.ExcelService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName ExcelServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2020/12/20 13:22
 * @Version 1.0
 */
@Service
public class ExcelServiceImpl implements ExcelService {

    public ExcelConstant exl;

    @Override
    public ResponseJson imports(MultipartFile excelFile, String module) {
        return null;
    }

    @Override
    public ResponseJson analyze(MultipartFile excelFile, String module) {
        ResponseJson resJson = new ResponseJson();
        try{
            if (exl.TAB_DON_BOOK_INFO.equals(module)) {
                BookInfoEntity  bookInfoEntity = new BookInfoEntity();
                resJson.setObject(bookInfoEntity);
            }
            if (exl.TAB_DON_BOOK_INFO.equals(module)) {

            }
            if (exl.TAB_DON_BOOK_INFO.equals(module)) {

            }
            if (exl.TAB_DON_BOOK_INFO.equals(module)) {

            } else {
                resJson.setMsg("无解析文件");
            }
        }catch (Exception E){
            resJson.setMsg("解析失败");

        }
        return resJson;
    }

    @Override
    public ResponseJson asyncImport(ResponseJson dtoJson, String id) {
        ResponseJson resJson = new ResponseJson();
        return resJson;
    }
}
