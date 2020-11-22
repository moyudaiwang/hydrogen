package com.element.hydrogen.mapper.book;

import com.element.hydrogen.entity.book.BookInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookInfoMapper {
    //int deleteByPrimaryKey(String donBookInfoId);

    int insert(BookInfoEntity record);

    //int insertSelective(BookInfoEntity record);

    BookInfoEntity selectByPrimaryKey(String donBookInfoId);

    //int updateByPrimaryKeySelective(BookInfoEntity record);

    int updateByPrimaryKey(BookInfoEntity record);


    List<BookInfoEntity> queryBookInfoPage(BookInfoEntity bookInfoEntity);

    //检测userId是否存在
    int checkBookId(BookInfoEntity bookInfoEntity);

    void insertBookInfo(BookInfoEntity bookInfoEntity);

    void updateBookInfo(BookInfoEntity bookInfoEntity);

    void deleteBookInfo(BookInfoEntity bookInfoEntity);

    int deleteBatchBookInfo(String[] donBookInfoIdList);
}