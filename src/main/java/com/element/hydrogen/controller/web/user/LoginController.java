package com.element.hydrogen.controller.web.user;

import com.element.hydrogen.entity.auth.DonAccountInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName LoginController
 * @Description 登录登出cro /web/portal
 * @Author yanyu
 * @Date 2021/1/30 17:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/portal")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     * @param donAccountInfoEntity
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseJson login(@RequestBody DonAccountInfoEntity donAccountInfoEntity){
        ResponseJson responseJson= new ResponseJson();
        responseJson = loginService.login(donAccountInfoEntity);
        return responseJson;
    }

    /**
     * 注册
     * @param param
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResponseJson register(@RequestBody DonAccountInfoEntity param){
        ResponseJson responseJson= new ResponseJson();
        responseJson = loginService.register(param);
        return responseJson;
    }

    /**
     * 获取验证码
     * @param donAccountInfoEntity
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/receiveCode",method = RequestMethod.POST)
    public ResponseJson receiveCode(@RequestBody DonAccountInfoEntity donAccountInfoEntity){
        ResponseJson responseJson= new ResponseJson();
        responseJson = loginService.receiveCode(donAccountInfoEntity);
        return responseJson;
    }

}
