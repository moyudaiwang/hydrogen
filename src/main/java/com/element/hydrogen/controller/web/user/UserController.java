package com.element.hydrogen.controller.web.user;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.user.UserEntity;
import com.element.hydrogen.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yanyu
 */
@RestController
@RequestMapping("/web/userInfo1")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * TODO 测试链接数据库
     * @param userName
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/getUserInfo1/{userName}",method = RequestMethod.GET)
    public String getUserInfo(@PathVariable String userName){
        UserEntity userEntity= new UserEntity();

        userEntity =userService.getUserInfo(userName);
        String name =userEntity.getSex();
        return name;
    }

    /**
     *测试json返回
     * @param userName
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/testJson/{userName}",method = RequestMethod.GET)
    public ResponseJson testJson(@PathVariable String userName){
        ResponseJson responseJson =new ResponseJson();
        responseJson =userService.testJson(userName);
        return responseJson;
    }


}
