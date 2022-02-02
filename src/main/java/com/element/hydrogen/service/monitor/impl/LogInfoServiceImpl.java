package com.element.hydrogen.service.monitor.impl;

import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.monitor.DonLogInfoEntity;
import com.element.hydrogen.mapper.monitor.DonLogInfoMapper;
import com.element.hydrogen.service.monitor.LogInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LogInfoServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2020/11/10 22:24
 * @Version 1.0
 */
@Service
public class LogInfoServiceImpl implements LogInfoService {

    @Autowired
    public DonLogInfoMapper donLogInfoMapper;

    public static ResponseJsonConstant res;

    @Override
    public ResponseJson query(DonLogInfoEntity donLogInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        PageHelper.startPage(donLogInfoEntity.getPageNum(), donLogInfoEntity.getPageSize());
        List<DonLogInfoEntity> donLogInfoEntityList = donLogInfoMapper.query(donLogInfoEntity);
        PageInfo<DonLogInfoEntity> pageInfo = new PageInfo<DonLogInfoEntity>(donLogInfoEntityList);
        resJson.setCode(res.SUCCESS);
        resJson.setObject(pageInfo);
        return resJson;
    }

    @Override
    public ResponseJson insert(DonLogInfoEntity donLogInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donLogInfoMapper.insert(donLogInfoEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_ADD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @Override
    public ResponseJson update(DonLogInfoEntity donLogInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donLogInfoMapper.updateByPrimaryKey(donLogInfoEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_UPD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @Override
    public ResponseJson delete(List<DonLogInfoEntity> donLogInfoEntityList) {
        ResponseJson resJson = new ResponseJson();
        try {
            for (DonLogInfoEntity donLogInfoEntity : donLogInfoEntityList) {
                donLogInfoMapper.deleteByPrimaryKey(donLogInfoEntity.getDonLogInfoId());
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
