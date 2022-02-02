package com.element.hydrogen.service.auth.impl;

import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.auth.DonMenuInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.mapper.auth.DonMenuInfoMapper;
import com.element.hydrogen.service.auth.MenuInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MenuInfoServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-03 01:24:41
 * @Version 1.0
 */
@Service
public class MenuInfoServiceImpl implements MenuInfoService {

    @Autowired
    public DonMenuInfoMapper donMenuInfoMapper;

    public static ResponseJsonConstant res;

    @Override
    public ResponseJson query(DonMenuInfoEntity donMenuInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        PageHelper.startPage(donMenuInfoEntity.getPageNum(), donMenuInfoEntity.getPageSize());
        List<DonMenuInfoEntity> donMenuInfoEntityList = donMenuInfoMapper.query(donMenuInfoEntity);
        PageInfo<DonMenuInfoEntity> pageInfo = new PageInfo<DonMenuInfoEntity>(donMenuInfoEntityList);
        resJson.setCode(res.SUCCESS);
        resJson.setObject(pageInfo);
        return resJson;
    }

    @Override
    public ResponseJson insert(DonMenuInfoEntity donMenuInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donMenuInfoMapper.insert(donMenuInfoEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_ADD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @Override
    public ResponseJson update(DonMenuInfoEntity donMenuInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donMenuInfoMapper.updateByPrimaryKey(donMenuInfoEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_UPD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @Override
    public ResponseJson delete(List<DonMenuInfoEntity> donMenuInfoEntityList) {
        ResponseJson resJson = new ResponseJson();
        try {
            for (DonMenuInfoEntity donMenuInfoEntity : donMenuInfoEntityList) {
                donMenuInfoMapper.deleteByPrimaryKey(donMenuInfoEntity.getDonMenuInfoId());
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
