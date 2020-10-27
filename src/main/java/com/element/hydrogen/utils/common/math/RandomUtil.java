package com.element.hydrogen.utils.common.math;

import com.element.hydrogen.entity.user.UserInfoEntity;
import com.element.hydrogen.mapper.user.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import sun.text.resources.cldr.gsw.FormatData_gsw;

import java.util.Random;

/**
 * @ClassName RandomUtil
 * @Description TODO
 * @Author yanyu
 * @Date 2020/9/6 18:51
 * @Version 1.0
 */
public class RandomUtil {
    public static final int RANDOM_START = 9999999;   //定义范围开始数字
    public static final int RANDOM_END = 1000000; //定义范围结束数字

    @Autowired
    public UserInfoMapper userInfoMapper;

    // 生成用户ID
   public void userIdRandom() {
       boolean seaFlag =true;
       UserInfoEntity userInfoEntity =new UserInfoEntity();
       do{
           int randomId = (int) (Math.random()*(RANDOM_END-RANDOM_START)+RANDOM_START);
           userInfoEntity.setUserId(randomId+"");
           int idFlag =userInfoMapper.checkUserId(userInfoEntity);
           seaFlag=idFlag==0?true:false;
       }while(seaFlag=false);


   }



}
