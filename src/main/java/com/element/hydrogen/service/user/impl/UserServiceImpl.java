package com.element.hydrogen.service.user.impl;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.user.UserEntity;
import com.element.hydrogen.mapper.user.UserMapper;
import com.element.hydrogen.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yanyu
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(String userName, String sex, String userId) {
        int insertResult = userMapper.insert(userName, sex,userId);
        return insertResult;
    }

    /**
     * TODO 测试链接数据库
     * @param userName
     * @return
     */
    @Override
    public UserEntity getUserInfo(String userName){
        UserEntity userEntity= new UserEntity();
        userEntity=userMapper.getUserInfo(userName);
        return userEntity;
    }

    @Override
    public ResponseJson testJson(String userName) {
        ResponseJson responseJson =new ResponseJson();
        responseJson.setStatus("true");
        responseJson.setMsg("okok测试成功");
        return responseJson;
    }


}
