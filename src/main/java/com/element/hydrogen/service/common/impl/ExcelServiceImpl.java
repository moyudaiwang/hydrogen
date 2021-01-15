package com.element.hydrogen.service.common.impl;

import com.element.hydrogen.constant.common.ExcelConstant;
import com.element.hydrogen.entity.book.BookInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.service.common.ExcelService;
import com.element.hydrogen.utils.common.excel.ExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public ResponseJson analyze(MultipartFile excelFile, String module) throws Exception {
        ResponseJson resJson = new ResponseJson();

        //String fileName="bookData.xlsx";
        //InputStream in = new FileInputStream(new File("D:\\Material\\bookData.xlsx"));
        Workbook wb = ExcelUtil.chooseWorkbook(excelFile.getOriginalFilename(), excelFile.getInputStream());
        // BookInfoEntity studentStatistics = new BookInfoEntity();

        //读取一个对象的信息
/*
        BookInfoEntity readDateT =
                ImportExeclUtil.readDateT(wb, studentStatistics, in, new Integer[] {4, 5}, new Integer[] {4, 5});
        System.out.println(readDateT);
*/

        //读取对象列表的信息
        BookInfoEntity studentBaseInfo = new BookInfoEntity();
        //第二行开始，到倒数第三行结束（总数减去两行）
        List<BookInfoEntity> readDateListT = ExcelUtil.readDateListT(wb, studentBaseInfo, 2, 0);
        System.out.println(readDateListT);

















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
