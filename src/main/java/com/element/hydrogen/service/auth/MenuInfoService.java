package com.element.hydrogen.service.auth;

import com.element.hydrogen.entity.auth.DonMenuInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;

import java.util.List;

/**
 * @InterfaceName MenuInfoService
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-03 01:24:41
 * @Version 1.0
 */
public interface MenuInfoService {
    ResponseJson query(DonMenuInfoEntity donMenuInfoEntity);

    ResponseJson insert(DonMenuInfoEntity donMenuInfoEntity);

    ResponseJson update(DonMenuInfoEntity donMenuInfoEntity);

    ResponseJson delete(List<DonMenuInfoEntity> donMenuInfoEntityList);
}
