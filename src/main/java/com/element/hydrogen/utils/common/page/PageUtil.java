package com.element.hydrogen.utils.common.page;

import com.element.hydrogen.entity.common.PageRequestEntity;
import com.element.hydrogen.entity.common.PageResultEntity;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName PageUtil
 * @Description TODO
 * @Author yanyu
 * @Date 2020/8/30 2:16
 * @Version 1.0
 */
public class PageUtil {

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequestEntity
     * @param pageInfo
     * @return
     */
    public static PageResultEntity getPageResult(PageRequestEntity pageRequestEntity, PageInfo<?> pageInfo) {
        PageResultEntity pageResultEntity = new PageResultEntity();
        pageResultEntity.setPageNum(pageInfo.getPageNum());
        pageResultEntity.setPageSize(pageInfo.getPageSize());
        pageResultEntity.setTotalSize(pageInfo.getTotal());
        pageResultEntity.setTotalPages(pageInfo.getPages());
        pageResultEntity.setContent(pageInfo.getList());
        return pageResultEntity;
    }
}
