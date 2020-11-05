package com.element.hydrogen.mapper.user;

import com.element.hydrogen.entity.user.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 */
@Mapper
public interface UserInfoMapper {
    //int deleteByPrimaryKey(String donUserInfoId);

    int insert(UserInfoEntity record);

    //int insertSelective(UserInfoEntity record);

    UserInfoEntity selectByPrimaryKey(String donUserInfoId);

    int updateByPrimaryKeySelective(UserInfoEntity record);

    //int updateByPrimaryKey(UserInfoEntity record);

    List<UserInfoEntity> queryUserInfoAll(UserInfoEntity userInfoEntity);

    List<UserInfoEntity> queryUserInfoPage(UserInfoEntity userInfoEntity);

    //检测userId是否存在
    int checkUserId(UserInfoEntity userInfoEntity);

    void insertUserInfo(UserInfoEntity userInfoEntity);

    void updateUserInfo(UserInfoEntity userInfoEntity);

    void deleteUserInfo(UserInfoEntity userInfoEntity);
}