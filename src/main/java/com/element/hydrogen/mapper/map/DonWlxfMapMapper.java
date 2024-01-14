package com.element.hydrogen.mapper.map;

import com.element.hydrogen.dto.common.MapDto;
import com.element.hydrogen.dto.map.MapParam;
import com.element.hydrogen.entity.map.DonWlxfMapEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DonWlxfMapMapper {
    int deleteByPrimaryKey(String donWlxfMapId);

    int insert(DonWlxfMapEntity record);

    int insertSelective(DonWlxfMapEntity record);

    DonWlxfMapEntity selectByPrimaryKey(String donWlxfMapId);

    int updateByPrimaryKeySelective(DonWlxfMapEntity record);

    int updateByPrimaryKey(DonWlxfMapEntity record);

    List<MapDto> initMapMenu(MapParam mapParam);

    List<DonWlxfMapEntity> queryMapPoints(MapParam mapParam);

}