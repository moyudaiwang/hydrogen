package com.element.hydrogen.service.book.impl;

import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.book.DonBookFlowEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.mapper.book.DonBookFlowMapper;
import com.element.hydrogen.service.book.BookFlowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookFlowServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-01 05:49:45
 * @Version 1.0
 */
@Service
public class BookFlowServiceImpl implements BookFlowService {

    @Autowired
    public DonBookFlowMapper donLogInfoMapper;

    public static ResponseJsonConstant res;

    @Override
    public ResponseJson query(DonBookFlowEntity donBookFlowEntity) {
        ResponseJson resJson = new ResponseJson();
        PageHelper.startPage(donBookFlowEntity.getPageNum(), donBookFlowEntity.getPageSize());
        List<DonBookFlowEntity> donBookFlowEntityList = donLogInfoMapper.query(donBookFlowEntity);
        PageInfo<DonBookFlowEntity> pageInfo = new PageInfo<DonBookFlowEntity>(donBookFlowEntityList);
        resJson.setCode(res.SUCCESS);
        resJson.setObject(pageInfo);
        return resJson;
    }

    @Override
    public ResponseJson insert(DonBookFlowEntity donBookFlowEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donLogInfoMapper.insert(donBookFlowEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_ADD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @Override
    public ResponseJson update(DonBookFlowEntity donBookFlowEntity) {
        ResponseJson resJson = new ResponseJson();
        try {
            donLogInfoMapper.updateByPrimaryKey(donBookFlowEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_UPD);
        } catch (Exception e) {
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @Override
    public ResponseJson delete(List<DonBookFlowEntity> donBookFlowEntityList) {
        ResponseJson resJson = new ResponseJson();
        try {
            for (DonBookFlowEntity donBookFlowEntity : donBookFlowEntityList) {
                donLogInfoMapper.deleteByPrimaryKey(donBookFlowEntity.getDonBookFlowId());
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
