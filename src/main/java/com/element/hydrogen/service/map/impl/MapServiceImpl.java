package com.element.hydrogen.service.map.impl;

import com.element.hydrogen.dto.common.MapDto;
import com.element.hydrogen.dto.map.MapParam;
import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.map.DonWlxfMapEntity;
import com.element.hydrogen.mapper.map.DonWlxfMapMapper;
import com.element.hydrogen.service.map.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MapServiceImpl
 * @Description TODO
 * @Author yanyu
 * @Date 2024/1/7 4:50
 * @Version 1.0
 */
@Service
public class MapServiceImpl implements MapService {

    @Autowired
    public DonWlxfMapMapper donWlxfMapMapper;

    @Override
    public ResponseJson initMapMenu(MapParam mapParam) {
        ResponseJson responseJson = new ResponseJson();
        try{
            List<MapDto> list = donWlxfMapMapper.initMapMenu(mapParam);
            responseJson.SUCCESS(list);
        }catch (Exception e){
            responseJson.FAIL();
        }
        return responseJson;
    }

    @Override
    public ResponseJson queryMapPoints(MapParam mapParam) {
        ResponseJson responseJson = new ResponseJson();
        try{
            if ("韦力寻访".equals(mapParam.getTable())){
                List<DonWlxfMapEntity> list = donWlxfMapMapper.queryMapPoints(mapParam);
                responseJson.SUCCESS(list);
            }
        }catch (Exception e){
            responseJson.FAIL();
        }
        return responseJson;
    }
}
