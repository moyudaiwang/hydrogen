package com.element.hydrogen.controller.web.user;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.user.UserInfoEntity;
import com.element.hydrogen.service.user.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserInfoController
 * @Description 用户管理
 * @Author yanyu
 * @Date 2020/8/30 0:07
 * @Version 1.0
 */
@RestController
@RequestMapping("/web/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @CrossOrigin
    @RequestMapping(value = "/getUserInfo/{userName}",method = RequestMethod.GET)
    public UserInfoEntity getUserInfo(@PathVariable String userName){
        UserInfoEntity userInfoEntity= new UserInfoEntity();
        String donUserInfoId ="AA9E9C4914024736B9113F07B82C06CD";
        userInfoEntity =userInfoService.selectByPrimaryKey(donUserInfoId);
        return userInfoEntity;
    }

    /**
     * 查询用户列表
     * @param userInfoEntity
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/queryUserInfoAll",method = RequestMethod.POST)
    public List<UserInfoEntity> queryUserInfoAll(@RequestBody UserInfoEntity userInfoEntity){
        List<UserInfoEntity> userInfoEntityList =new ArrayList<>();
        userInfoEntityList =userInfoService.queryUserInfoAll(userInfoEntity);
        return userInfoEntityList;
    }

    /**
     * 分页查询用户列表
     * @param userInfoEntity
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/queryUserInfoPage",method = RequestMethod.POST)
    public PageInfo<UserInfoEntity> queryUserInfoPage(@RequestBody UserInfoEntity userInfoEntity){
        PageInfo<UserInfoEntity> pageInfo = new PageInfo<UserInfoEntity>();
        System.out.println(userInfoEntity.getUserName());
        PageHelper.startPage(userInfoEntity.getPageNum(), userInfoEntity.getPageSize());
        pageInfo =userInfoService.queryUserInfoPage(userInfoEntity);
        return pageInfo;
    }

    /**
     * 新增用户信息
     * @param userInfoEntity
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/insertUserInfo",method = RequestMethod.POST)
    public ResponseJson insertUserInfo(@RequestBody UserInfoEntity userInfoEntity){
        ResponseJson resJson = new ResponseJson();
        userInfoEntity.setOperator("molecule");
        try{
            resJson =userInfoService.insertUserInfo(userInfoEntity);
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMessage("新增失败");
        }
        return resJson;
    }
    /**
     * 修改用户信息
     * @param userInfoEntity
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public ResponseJson updateUserInfo(@RequestBody UserInfoEntity userInfoEntity){
        ResponseJson resJson = new ResponseJson();
        userInfoEntity.setOperator("molecule");
        try{
            resJson =userInfoService.updateUserInfo(userInfoEntity);
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMessage("修改失败");
        }
        return resJson;
    }
    /**
     * 删除用户信息
     * @param userInfoEntity
     * @return
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteUserInfo",method = RequestMethod.POST)
    public ResponseJson deleteUserInfo(@RequestBody UserInfoEntity userInfoEntity){
        ResponseJson resJson = new ResponseJson();
        userInfoEntity.setOperator("molecule");
        try{
            resJson =userInfoService.deleteUserInfo(userInfoEntity);
        }catch (Exception e){
            resJson.setCode("500");
            resJson.setStatus("false");
            resJson.setMessage("删除失败");
        }
        return resJson;
    }
}
