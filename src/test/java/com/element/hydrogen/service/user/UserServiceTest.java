package com.element.hydrogen.service.user;

import com.element.hydrogen.entity.user.UserInfoEntity;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName UserServiceTest
 * @Description TODO
 * @Author yanyu
 * @Date 2020/8/30 4:18
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    public UserInfoService userInfoService;

    @Test
    public void setpageInfo(){
        UserInfoEntity userInfoEntity =new UserInfoEntity();
        userInfoEntity.setUserName("綦智");
        //userInfoEntity.setNickname();
        //PageInfo<UserInfoEntity> pageInfo  = userInfoService.queryUserInfoPage(userInfoEntity);
       // System.out.println("publicpublicpublic"+pageInfo.toString());
    }
}
