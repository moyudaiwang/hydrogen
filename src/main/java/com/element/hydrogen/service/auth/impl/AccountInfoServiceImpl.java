package com.element.hydrogen.service.auth.impl;

import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.auth.DonAccountInfoEntity;
import com.element.hydrogen.mapper.auth.DonAccountInfoMapper;
import com.element.hydrogen.service.auth.AccountInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AccountInfoServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-03 02:27:00
 * @Version 1.0
 */
@Service
public class AccountInfoServiceImpl implements AccountInfoService {

    @Autowired
    public DonAccountInfoMapper donAccountInfoMapper;

    public static ResponseJsonConstant res;

    @Override
    public ResponseJson query(DonAccountInfoEntity donAccountInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        PageHelper.startPage(donAccountInfoEntity.getPageNum(), donAccountInfoEntity.getPageSize());
        List<DonAccountInfoEntity> donAccountInfoEntityList = donAccountInfoMapper.query(donAccountInfoEntity);
        PageInfo<DonAccountInfoEntity> pageInfo = new PageInfo<DonAccountInfoEntity>(donAccountInfoEntityList);
        resJson.setCode(res.SUCCESS);
        resJson.setObject(pageInfo);
        return resJson;
    }

    @Override
    public ResponseJson insert(DonAccountInfoEntity donAccountInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donAccountInfoMapper.insert(donAccountInfoEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_ADD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @Override
    public ResponseJson update(DonAccountInfoEntity donAccountInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donAccountInfoMapper.updateByPrimaryKey(donAccountInfoEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_UPD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @Override
    public ResponseJson delete(List<DonAccountInfoEntity> donAccountInfoEntityList) {
        ResponseJson resJson = new ResponseJson();
        try {
            for (DonAccountInfoEntity donAccountInfoEntity : donAccountInfoEntityList) {
                donAccountInfoMapper.deleteByPrimaryKey(donAccountInfoEntity.getDonAccountInfoId());
            }
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_DEL);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_DEL);
        }
        return resJson;
    }
}
