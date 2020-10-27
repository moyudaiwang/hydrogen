import com.element.hydrogen.entity.common.DaysEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringRunner.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String, DaysEntity> redisTemplate;
    private DaysEntity d;
    @Before
    public void before(){
        d=new DaysEntity();
        d.setDate("123");
        d.setDaysId("456");
        d.setItemNumber(123);
        d.setOpenId("dawda");
        d.setTitle("title");
    }
    @Test
    public void testSet(){
        this.redisTemplate.opsForValue().set("days",d);
        System.out.println((redisTemplate.opsForValue().get("days")));
    }
}