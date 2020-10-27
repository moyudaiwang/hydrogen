package com.element.hydrogen.service.user;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.user.UserEntity;

import java.net.Socket;

public interface UserService {

    /**
     * TODO 测试链接数据库
     * @param userName
     * @return
     */
    UserEntity getUserInfo(String userName);

    ResponseJson testJson(String userName);
  //  Socket chatSocket = new Socket("196.164.1.102",6359);
}
