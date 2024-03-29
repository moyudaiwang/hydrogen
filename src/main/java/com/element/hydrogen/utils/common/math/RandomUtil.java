package com.element.hydrogen.utils.common.math;

import com.element.hydrogen.entity.user.DonUserInfoEntity;
import com.element.hydrogen.mapper.user.DonUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

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
    public DonUserInfoMapper donUserInfoMapper;

    // 生成用户ID
   public void userIdRandom() {
       boolean seaFlag =true;
       DonUserInfoEntity donUserInfoEntity =new DonUserInfoEntity();
       do{
           int randomId = (int) (Math.random()*(RANDOM_END-RANDOM_START)+RANDOM_START);
           donUserInfoEntity.setUserId(randomId+"");
           int idFlag = 0;
           //idFlag = donUserInfoMapper.checkUserId(donUserInfoEntity);
           seaFlag=idFlag==0?true:false;
       }while(seaFlag=false);


   }
    // 生成5位随机数
   public String randomFive() {
       Random r = new Random(1);
       String randomStr = "";
        for(int i=0 ; i<1;  i++) {
            int ran1 = r.nextInt(100000);
            randomStr =ran1+"";
        }
        return randomStr;
   }

    /**
     * 6位数字验证码
     * @return
     */
   public String randomSix() {
       String randomStr = "";
       int flag = new Random().nextInt(999999);
       if (flag < 100000) {
           flag += 100000;
       }
       randomStr +=flag;
        return randomStr;
   }





}
