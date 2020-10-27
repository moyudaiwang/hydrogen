package com.element.hydrogen.mapper.user;

import com.element.hydrogen.entity.user.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author yanyu
 */

@Repository
@Mapper
public interface UserMapper {

    //使用注解式开发查询语句
    @Select("SELECT * FROM DON_USER_INFO WHERE USER_NAME = #{userName}")
    UserEntity getUserByName(@Param("userName") String userName);

    @Insert("INSERT  INTO DON_USER_INFO(USER_NAME ,SEX,DON_USER_INFO_ID)  VALUES(#{userName},#{sex},#{userId})")
    int insert(@Param("userName") String userName, @Param("sex") String sex, @Param("userId") String userId);


    /**
     * TODO 测试链接数据库
     * @param userName
     * @return
     */
    UserEntity getUserInfo(@Param("userName") String userName);

}
