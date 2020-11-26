package com.element.hydrogen.service.book;

import com.element.hydrogen.entity.book.BookInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.github.pagehelper.PageInfo;

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
     * @param bookInfoEntity
     * @return
     */
    PageInfo<BookInfoEntity> queryBookInfoPage(BookInfoEntity bookInfoEntity);

    ResponseJson insertBookInfo(BookInfoEntity bookInfoEntity);

    ResponseJson updateBookInfo(BookInfoEntity bookInfoEntity);

    ResponseJson deleteBookInfo(BookInfoEntity bookInfoEntity);

    ResponseJson deleteBatchBookInfo(String donBookInfoIds);
}
