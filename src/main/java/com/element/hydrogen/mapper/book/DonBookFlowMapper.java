package com.element.hydrogen.mapper.book;

import com.element.hydrogen.entity.book.DonBookFlowEntity;

import java.util.List;

public interface DonBookFlowMapper {
    int deleteByPrimaryKey(String donBookFlowId);

    int insert(DonBookFlowEntity record);

    int insertSelective(DonBookFlowEntity record);

    DonBookFlowEntity selectByPrimaryKey(String donBookFlowId);

    int updateByPrimaryKeySelective(DonBookFlowEntity record);

    int updateByPrimaryKey(DonBookFlowEntity record);

    List<DonBookFlowEntity> query(DonBookFlowEntity donBookFlowEntity);
}