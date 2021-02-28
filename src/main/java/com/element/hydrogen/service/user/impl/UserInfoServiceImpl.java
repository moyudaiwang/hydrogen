package com.element.hydrogen.service.user.impl;

import com.element.hydrogen.entity.common.PageRequestEntity;
import com.element.hydrogen.entity.common.PageResultEntity;
import com.element.hydrogen.entity.common.ResponseJson;
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
        System.out.println("----------");
        System.out.println(userInfoEntityList);
        System.out.println("---------------");
        PageInfo<UserInfoEntity> pageInfo =new PageInfo<UserInfoEntity>(userInfoEntityList);
        System.out.println("user-----------"+userInfoEntityList);
        System.out.println("page------------"+pageInfo);
        return pageInfo;
    }

    @Override
    public ResponseJson insertUserInfo(UserInfoEntity userInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try{
            userInfoMapper.insertUserInfo(userInfoEntity);
            resJson.setCode("200");
            resJson.setStatus("true");
            resJson.setMsg("新增成功");
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMsg("新增失败");
        }
        return resJson;
    }

    @Override
    public ResponseJson updateUserInfo(UserInfoEntity userInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try{
            userInfoMapper.updateUserInfo(userInfoEntity);
            resJson.setCode("200");
            resJson.setStatus("true");
            resJson.setMsg("修改成功");
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMsg("修改失败");
        }
        return resJson;
    }

    @Override
    public ResponseJson deleteUserInfo(UserInfoEntity userInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try{
            userInfoMapper.deleteUserInfo(userInfoEntity);
            resJson.setCode("200");
            resJson.setStatus("true");
            resJson.setMsg("删除成功");
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMsg("删除失败");
        }
        return resJson;
    }
/*

    @Override
    public PageResultEntity findPage(UserInfoEntity userInfoEntity) {
        return PageUtil.getPageResult(userInfoEntity, getPageInfo(userInfoEntity));
    }*/

}
