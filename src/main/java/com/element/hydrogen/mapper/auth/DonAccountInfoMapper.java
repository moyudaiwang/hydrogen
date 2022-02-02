package com.element.hydrogen.mapper.auth;

import com.element.hydrogen.entity.auth.DonAccountInfoEntity;

import java.util.List;

public interface DonAccountInfoMapper {
    int deleteByPrimaryKey(String donAccountInfoId);

    int insert(DonAccountInfoEntity record);

    int insertSelective(DonAccountInfoEntity record);

    DonAccountInfoEntity selectByPrimaryKey(String donAccountInfoId);

    int updateByPrimaryKeySelective(DonAccountInfoEntity record);

    int updateByPrimaryKey(DonAccountInfoEntity record);

    List<DonAccountInfoEntity> query(DonAccountInfoEntity donAccountInfoEntity);
}