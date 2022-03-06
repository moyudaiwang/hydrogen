package com.element.hydrogen.mapper.graph;

import com.element.hydrogen.entity.graph.DonHlmInfoEntity;
import com.element.hydrogen.entity.graph.DonHlmRelEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DonHlmRelMapper {
    int deleteByPrimaryKey(String donHlmRelId);

    int insert(DonHlmRelEntity record);

    int insertSelective(DonHlmRelEntity record);

    DonHlmRelEntity selectByPrimaryKey(String donHlmRelId);

    int updateByPrimaryKeySelective(DonHlmRelEntity record);

    int updateByPrimaryKey(DonHlmRelEntity record);

    List<DonHlmRelEntity> query(DonHlmRelEntity donHlmRelEntity);
}