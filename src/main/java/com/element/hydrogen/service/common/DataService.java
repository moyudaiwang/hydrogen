package com.element.hydrogen.service.common;

import com.element.hydrogen.entity.common.ResponseJson;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @InterfaceName DataService
 * @Description TODO
 * @Author yanyu
 * @Date 2021/4/12 23:48
 * @Version 1.0
 */
public interface DataService {


    ResponseJson createTable(MultipartFile[] excelFiles, String module) throws IOException;
}
