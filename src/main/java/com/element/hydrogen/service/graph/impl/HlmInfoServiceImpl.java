package com.element.hydrogen.service.graph.impl;

import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.graph.DonHlmInfoEntity;
import com.element.hydrogen.mapper.graph.DonHlmInfoMapper;
import com.element.hydrogen.service.graph.HlmInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName HlmInfoServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-26 21:35:02
 * @Version 1.0
 */
@Service
public class HlmInfoServiceImpl implements HlmInfoService {

    @Autowired
    public DonHlmInfoMapper donLogInfoMapper;

    public static ResponseJsonConstant res;

    @Override
    public ResponseJson query(DonHlmInfoEntity donHlmInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        PageHelper.startPage(donHlmInfoEntity.getPageNum(), donHlmInfoEntity.getPageSize());
        List<DonHlmInfoEntity> donHlmInfoEntityList = donLogInfoMapper.query(donHlmInfoEntity);
        PageInfo<DonHlmInfoEntity> pageInfo = new PageInfo<DonHlmInfoEntity>(donHlmInfoEntityList);
        resJson.setCode(res.SUCCESS);
        resJson.setObject(pageInfo);
        return resJson;
    }

    @Override
    public ResponseJson insert(DonHlmInfoEntity donHlmInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donLogInfoMapper.insert(donHlmInfoEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_ADD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @Override
    public ResponseJson update(DonHlmInfoEntity donHlmInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donLogInfoMapper.updateByPrimaryKey(donHlmInfoEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_UPD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @Override
    public ResponseJson delete(List<DonHlmInfoEntity> donHlmInfoEntityList) {
        ResponseJson resJson = new ResponseJson();
        try {
            for (DonHlmInfoEntity donHlmInfoEntity : donHlmInfoEntityList) {
                donLogInfoMapper.deleteByPrimaryKey(donHlmInfoEntity.getDonHlmInfoId());
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
