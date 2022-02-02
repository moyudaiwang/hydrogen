package com.element.hydrogen.service.user;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.user.DonUserInfoEntity;

import java.util.List;

/**
 * @InterfaceName UserInfoService
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-03 03:31:50
 * @Version 1.0
 */
public interface UserInfoService {
    ResponseJson query(DonUserInfoEntity donUserInfoEntity);

    ResponseJson insert(DonUserInfoEntity donUserInfoEntity);

    ResponseJson update(DonUserInfoEntity donUserInfoEntity);

    ResponseJson delete(List<DonUserInfoEntity> donUserInfoEntityList);
}
