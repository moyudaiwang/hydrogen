package com.element.hydrogen.controller.web.user;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.user.AccountCodeEntity;
import com.element.hydrogen.service.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName LoginController
 * @Description 登录登出cro
 * @Author yanyu
 * @Date 2021/1/30 17:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @CrossOrigin
    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public ResponseJson check(@RequestBody AccountCodeEntity accountCodeEntity){
        ResponseJson responseJson= new ResponseJson();
        responseJson =loginService.check(accountCodeEntity);
        return responseJson;
    }


}
