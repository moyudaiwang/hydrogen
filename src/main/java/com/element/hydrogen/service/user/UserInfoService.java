package com.element.hydrogen.service.user;

import com.element.hydrogen.entity.common.PageResultEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.user.UserInfoEntity;
import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @InterfaceName UserInfoService
 * @Description TODO
 * @Author yanyu
 * @Date 2020/8/30 0:03
 * @Version 1.0
 */
public interface UserInfoService {
    int deleteByPrimaryKey(String donUserInfoId);

    int insert(UserInfoEntity record);

    int insertSelective(UserInfoEntity record);

    UserInfoEntity selectByPrimaryKey(String donUserInfoId);

    int updateByPrimaryKeySelective(UserInfoEntity record);

    int updateByPrimaryKey(UserInfoEntity record);

    /**
     * 查询用户列表
     * @param userInfoEntity
     * @return
     */
    List<UserInfoEntity> queryUserInfoAll(UserInfoEntity userInfoEntity);

    /**
     * 分页查询用户列表
     * @param userInfoEntity
     * @return
     */
    PageInfo<UserInfoEntity> queryUserInfoPage(UserInfoEntity userInfoEntity);

    ResponseJson insertUserInfo(UserInfoEntity userInfoEntity);
}
