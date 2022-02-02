package com.element.hydrogen.mapper.auth;

import com.element.hydrogen.entity.auth.DonMenuInfoEntity;

import java.util.List;

public interface DonMenuInfoMapper {
    int deleteByPrimaryKey(String donMenuInfoId);

    int insert(DonMenuInfoEntity record);

    int insertSelective(DonMenuInfoEntity record);

    DonMenuInfoEntity selectByPrimaryKey(String donMenuInfoId);

    int updateByPrimaryKeySelective(DonMenuInfoEntity record);

    int updateByPrimaryKey(DonMenuInfoEntity record);

    List<DonMenuInfoEntity> query(DonMenuInfoEntity donMenuInfoEntity);
}