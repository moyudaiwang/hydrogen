package com.element.hydrogen.mapper.monitor;

import com.element.hydrogen.entity.monitor.DonLogInfoEntity;

import java.util.List;

public interface DonLogInfoMapper {
    int deleteByPrimaryKey(String donLogInfoId);

    int insert(DonLogInfoEntity record);

    int insertSelective(DonLogInfoEntity record);

    DonLogInfoEntity selectByPrimaryKey(String donLogInfoId);

    int updateByPrimaryKeySelective(DonLogInfoEntity record);

    int updateByPrimaryKey(DonLogInfoEntity record);

    List<DonLogInfoEntity> query(DonLogInfoEntity donLogInfoEntity);
}