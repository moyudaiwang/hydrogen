package com.element.hydrogen.service.book.impl;

import com.element.hydrogen.constant.common.ResponseJsonConstant;
import com.element.hydrogen.entity.book.DonBookInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.mapper.book.DonBookInfoMapper;
import com.element.hydrogen.service.book.BookInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BookInfoServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2020/11/10 22:24
 * @Version 1.0
 */
@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    public DonBookInfoMapper donBookInfoMapper;

    public static ResponseJsonConstant res;

    /**
     * 分页查询用户列表
     * @param donBookInfoEntity
     * @return
     */
    @Override
    public ResponseJson query(DonBookInfoEntity donBookInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        PageHelper.startPage(donBookInfoEntity.getPageNum(), donBookInfoEntity.getPageSize());
        List<DonBookInfoEntity> donBookInfoEntityList = donBookInfoMapper.query(donBookInfoEntity);
        PageInfo<DonBookInfoEntity> pageInfo =new PageInfo<DonBookInfoEntity>(donBookInfoEntityList);
        resJson.setCode(res.SUCCESS);
        resJson.setObject(pageInfo);
        return resJson;
    }

    @Override
    public ResponseJson insert(DonBookInfoEntity donBookInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try{
            donBookInfoMapper.insert(donBookInfoEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_ADD);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_ADD);
        }
        return resJson;
    }

    @Override
    public ResponseJson update(DonBookInfoEntity donBookInfoEntity) {
        ResponseJson resJson = new ResponseJson();
        try{
            donBookInfoMapper.updateByPrimaryKey(donBookInfoEntity);
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_UPD);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_UPD);
        }
        return resJson;
    }

    @Override
    public ResponseJson delete(List<DonBookInfoEntity> donBookInfoEntityList) {
        ResponseJson resJson = new ResponseJson();
        try{
            for (DonBookInfoEntity donBookInfoEntity:donBookInfoEntityList) {
                donBookInfoMapper.deleteByPrimaryKey(donBookInfoEntity.getDonBookInfoId());
            }
            resJson.setCode(res.SUCCESS);
            resJson.setMsg(res.SUC_DEL);
        }catch (Exception e){
            resJson.setCode(res.FAIL);
            resJson.setMsg(res.FAIL_DEL);
        }
        return resJson;
    }
}
