package com.element.hydrogen.service.monitor;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.monitor.DonLogInfoEntity;

import java.util.List;

/**
 * @InterfaceName LogInfoService
 * @Description TODO
 * @Author yanyu
 * @Date 2022/1/29 15:53
 * @Version 1.0
 */
public interface LogInfoService {
    ResponseJson query(DonLogInfoEntity donLogInfoEntity);

    ResponseJson insert(DonLogInfoEntity donLogInfoEntity);

    ResponseJson update(DonLogInfoEntity donLogInfoEntity);

    ResponseJson delete(List<DonLogInfoEntity> donLogInfoEntityList);
}
