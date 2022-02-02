package com.element.hydrogen.mapper.book;

import com.element.hydrogen.entity.book.DonBookInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DonBookInfoMapper {
    int deleteByPrimaryKey(String donBookInfoId);

    int insert(DonBookInfoEntity record);

    int insertSelective(DonBookInfoEntity record);

    DonBookInfoEntity selectByPrimaryKey(String donBookInfoId);

    int updateByPrimaryKeySelective(DonBookInfoEntity record);

    int updateByPrimaryKey(DonBookInfoEntity record);

    /**
     * 分页查询
     * @param donBookInfoEntity
     * @return
     */
    List<DonBookInfoEntity> query(DonBookInfoEntity donBookInfoEntity);
}