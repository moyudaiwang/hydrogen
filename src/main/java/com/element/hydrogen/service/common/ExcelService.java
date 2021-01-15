package com.element.hydrogen.service.common;

import com.element.hydrogen.entity.common.ResponseJson;
import org.springframework.web.multipart.MultipartFile;

/**
 * @InterfaceName ExcelService
 * @Description TODO
 * @Author yanyu
 * @Date 2020/12/20 13:22
 * @Version 1.0
 */
public interface ExcelService {


    ResponseJson imports(MultipartFile excelFile, String module);

    ResponseJson analyze(MultipartFile excelFile, String module) throws Exception;

    ResponseJson asyncImport(ResponseJson dtoJson, String id);
}
