package com.element.hydrogen.service.book;

import com.element.hydrogen.entity.book.DonBookInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;

import java.util.List;

/**
 * @InterfaceName BookInfoService
 * @Description TODO
 * @Author yanyu
 * @Date 2020/11/10 22:24
 * @Version 1.0
 */
public interface BookInfoService {


    /**
     * 分页查询用户列表
     * @param donBookInfoEntity
     * @return
     */
    ResponseJson query(DonBookInfoEntity donBookInfoEntity);

    ResponseJson insert(DonBookInfoEntity donBookInfoEntity);

    ResponseJson update(DonBookInfoEntity donBookInfoEntity);

    ResponseJson delete(List<DonBookInfoEntity> donBookInfoEntityList);
}
