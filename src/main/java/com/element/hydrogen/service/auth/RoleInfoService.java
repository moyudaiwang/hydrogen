package com.element.hydrogen.service.auth;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.auth.DonRoleInfoEntity;

import java.util.List;

/**
 * @InterfaceName RoleInfoService
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-03 02:51:02
 * @Version 1.0
 */
public interface RoleInfoService {
    ResponseJson query(DonRoleInfoEntity donRoleInfoEntity);

    ResponseJson insert(DonRoleInfoEntity donRoleInfoEntity);

    ResponseJson update(DonRoleInfoEntity donRoleInfoEntity);

    ResponseJson delete(List<DonRoleInfoEntity> donRoleInfoEntityList);
}
