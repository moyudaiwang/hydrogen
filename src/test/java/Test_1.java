import com.element.hydrogen.entity.user.UserInfoEntity;
import com.element.hydrogen.service.user.UserInfoService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test_1{
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    public UserInfoService userInfoService;
    @Test
    public void set(){
        redisTemplate.opsForValue().set("myKey","myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }



    @Test
    public void setpageInfo(){
        UserInfoEntity userInfoEntity =new UserInfoEntity();
        userInfoEntity.setUserName("綦智");
        //userInfoEntity.setNickname();
       // PageInfo<UserInfoEntity> pageInfo  = userInfoService.queryUserInfoPage(userInfoEntity);
      //  System.out.println("publicpublicpublic"+pageInfo.toString());
    }
}