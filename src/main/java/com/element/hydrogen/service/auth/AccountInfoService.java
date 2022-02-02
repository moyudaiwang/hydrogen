package com.element.hydrogen.service.auth;

import com.element.hydrogen.entity.auth.DonAccountInfoEntity;
import com.element.hydrogen.entity.common.ResponseJson;

import java.util.List;

/**
 * @InterfaceName AccountInfoService
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-03 02:27:00
 * @Version 1.0
 */
public interface AccountInfoService {
    ResponseJson query(DonAccountInfoEntity donAccountInfoEntity);

    ResponseJson insert(DonAccountInfoEntity donAccountInfoEntity);

    ResponseJson update(DonAccountInfoEntity donAccountInfoEntity);

    ResponseJson delete(List<DonAccountInfoEntity> donAccountInfoEntityList);
}
