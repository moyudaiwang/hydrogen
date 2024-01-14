package com.element.hydrogen.mapper.auth;

import com.element.hydrogen.entity.auth.DonAccountInfoEntity;

import java.util.List;

/**
 * @author yanyu
 */
public interface DonAccountInfoMapper {
    int deleteByPrimaryKey(String donAccountInfoId);

    int insert(DonAccountInfoEntity record);

    int insertSelective(DonAccountInfoEntity record);

    DonAccountInfoEntity selectByPrimaryKey(String donAccountInfoId);

    int updateByPrimaryKeySelective(DonAccountInfoEntity record);

    int updateByPrimaryKey(DonAccountInfoEntity record);

    List<DonAccountInfoEntity> query(DonAccountInfoEntity donAccountInfoEntity);

    /***
     * 校验用户ID、用户名，手机号，邮箱是否存在
     * @param param
     * @return
     */
    int check(DonAccountInfoEntity param);
}