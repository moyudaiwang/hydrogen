package com.element.hydrogen.service.graph.impl;

import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.graph.DonHlmRelEntity;
import com.element.hydrogen.mapper.graph.DonHlmRelMapper;
import com.element.hydrogen.service.graph.HlmRelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName HlmRelServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-26 22:07:28
 * @Version 1.0
 */
@Service
public class HlmRelServiceImpl implements HlmRelService {

    @Autowired
    public DonHlmRelMapper donLogInfoMapper;

    public static ResponseJsonConstant res;

    @Override
    public ResponseJson query(DonHlmRelEntity donHlmRelEntity) {
        ResponseJson resJson = new ResponseJson();
        PageHelper.startPage(donHlmRelEntity.getPageNum(), donHlmRelEntity.getPageSize());
        List<DonHlmRelEntity> donHlmRelEntityList = donLogInfoMapper.query(donHlmRelEntity);
        PageInfo<DonHlmRelEntity> pageInfo = new PageInfo<DonHlmRelEntity>(donHlmRelEntityList);
        resJson.setCode(res.SUCCESS);
        resJson.setObject(pageInfo);
        return resJson;
    }

    @Override
    public ResponseJson insert(DonHlmRelEntity donHlmRelEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donLogInfoMapper.insert(donHlmRelEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_ADD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @Override
    public ResponseJson update(DonHlmRelEntity donHlmRelEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donLogInfoMapper.updateByPrimaryKey(donHlmRelEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_UPD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @Override
    public ResponseJson delete(List<DonHlmRelEntity> donHlmRelEntityList) {
        ResponseJson resJson = new ResponseJson();
        try {
            for (DonHlmRelEntity donHlmRelEntity : donHlmRelEntityList) {
                donLogInfoMapper.deleteByPrimaryKey(donHlmRelEntity.getDonHlmRelId());
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
