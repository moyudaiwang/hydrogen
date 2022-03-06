package com.element.hydrogen.mapper.graph;

import com.element.hydrogen.entity.graph.DonHlmInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DonHlmInfoMapper {
    int deleteByPrimaryKey(String donHlmInfoId);

    int insert(DonHlmInfoEntity record);

    int insertSelective(DonHlmInfoEntity record);

    DonHlmInfoEntity selectByPrimaryKey(String donHlmInfoId);

    int updateByPrimaryKeySelective(DonHlmInfoEntity record);

    int updateByPrimaryKey(DonHlmInfoEntity record);

    List<DonHlmInfoEntity> query(DonHlmInfoEntity donHlmInfoEntity);
}