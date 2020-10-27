package com.element.hydrogen.service.user.impl;

import com.element.hydrogen.entity.common.PageRequestEntity;
import com.element.hydrogen.entity.common.PageResultEntity;
import com.element.hydrogen.entity.user.UserInfoEntity;
import com.element.hydrogen.mapper.user.UserInfoMapper;
import com.element.hydrogen.service.user.UserInfoService;
import com.element.hydrogen.utils.common.page.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserInfoServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2020/8/30 0:03
 * @Version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    public UserInfoMapper userInfoMapper;


    @Override
    public int deleteByPrimaryKey(String donUserInfoId) {
        return 0;
    }

    @Override
    public int insert(UserInfoEntity record) {
        return 0;
    }

    @Override
    public int insertSelective(UserInfoEntity record) {
        return 0;
    }

    @Override
    public UserInfoEntity selectByPrimaryKey(String donUserInfoId) {
        UserInfoEntity  userInfoEntity =new UserInfoEntity();
        userInfoEntity =userInfoMapper.selectByPrimaryKey(donUserInfoId);
        return userInfoEntity;
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfoEntity record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserInfoEntity record) {
        return 0;
    }

    /**
     * 查询用户列表
     * @param userInfoEntity
     * @return
     */
    @Override
    public List<UserInfoEntity> queryUserInfoAll(UserInfoEntity userInfoEntity) {
        return userInfoMapper.queryUserInfoAll(userInfoEntity);
    }

    /**
     * 分页查询用户列表
     * @param userInfoEntity
     * @return
     */
    @Override
    public PageInfo<UserInfoEntity> queryUserInfoPage(UserInfoEntity userInfoEntity) {
        PageHelper.startPage(userInfoEntity.getPageNum(), userInfoEntity.getPageSize());
        List<UserInfoEntity> userInfoEntityList = userInfoMapper.queryUserInfoPage(userInfoEntity);
        PageInfo<UserInfoEntity> pageInfo =new PageInfo<UserInfoEntity>(userInfoEntityList);
        System.out.println("user-----------"+userInfoEntityList);
        System.out.println("page------------"+pageInfo);
        return pageInfo;
    }
/*

    @Override
    public PageResultEntity findPage(UserInfoEntity userInfoEntity) {
        return PageUtil.getPageResult(userInfoEntity, getPageInfo(userInfoEntity));
    }*/

}
