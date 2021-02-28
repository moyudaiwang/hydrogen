package com.element.hydrogen.service.user;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.user.AccountCodeEntity;

/**
 * @InterfaceName LoginService
 * @Description TODO
 * @Author yanyu
 * @Date 2021/1/30 17:29
 * @Version 1.0
 */
public interface LoginService {
    ResponseJson check(AccountCodeEntity accountCodeEntity);
}
