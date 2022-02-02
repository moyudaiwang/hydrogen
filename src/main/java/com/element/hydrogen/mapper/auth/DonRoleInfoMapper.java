package com.element.hydrogen.mapper.auth;

import com.element.hydrogen.entity.auth.DonRoleInfoEntity;

import java.util.List;

public interface DonRoleInfoMapper {

    int deleteByPrimaryKey(String donRoleInfoId);

    int insert(DonRoleInfoEntity record);

    int insertSelective(DonRoleInfoEntity record);

    DonRoleInfoEntity selectByPrimaryKey(String donRoleInfoId);

    int updateByPrimaryKeySelective(DonRoleInfoEntity record);

    int updateByPrimaryKey(DonRoleInfoEntity record);

    List<DonRoleInfoEntity> query(DonRoleInfoEntity donRoleInfoEntity);
}