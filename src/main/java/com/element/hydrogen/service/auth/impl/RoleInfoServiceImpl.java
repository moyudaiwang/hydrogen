package com.element.hydrogen.service.auth.impl;

import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.auth.DonRoleInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.mapper.auth.DonRoleInfoMapper;
import com.element.hydrogen.service.auth.RoleInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleInfoServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-03 02:51:02
 * @Version 1.0
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService{

    @Autowired
    public DonRoleInfoMapper donRoleInfoMapper;

    public static ResponseJsonConstant res;

    @Override
    public ResponseJson query(DonRoleInfoEntity donRoleInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        PageHelper.startPage(donRoleInfoEntity.getPageNum(), donRoleInfoEntity.getPageSize());
        List<DonRoleInfoEntity> donRoleInfoEntityList = donRoleInfoMapper.query(donRoleInfoEntity);
        PageInfo<DonRoleInfoEntity> pageInfo = new PageInfo<DonRoleInfoEntity>(donRoleInfoEntityList);
        resJson.setCode(res.SUCCESS);
        resJson.setObject(pageInfo);
        return resJson;
    }

    @Override
    public ResponseJson insert(DonRoleInfoEntity donRoleInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donRoleInfoMapper.insert(donRoleInfoEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_ADD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @Override
    public ResponseJson update(DonRoleInfoEntity donRoleInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donRoleInfoMapper.updateByPrimaryKey(donRoleInfoEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_UPD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @Override
    public ResponseJson delete(List<DonRoleInfoEntity> donRoleInfoEntityList) {
        ResponseJson resJson = new ResponseJson();
        try {
            for (DonRoleInfoEntity donRoleInfoEntity : donRoleInfoEntityList) {
                donRoleInfoMapper.deleteByPrimaryKey(donRoleInfoEntity.getDonRoleInfoId());
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
