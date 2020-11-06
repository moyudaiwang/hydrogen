package com.element.hydrogen.service.life;

import com.element.hydrogen.entity.common.ResponseJson;

/**
 * @InterfaceName LifeService
 * @Description TODO
 * @Author yanyu
 * @Date 2020/11/5 23:19
 * @Version 1.0
 */
public interface LifeService {
    ResponseJson mobileQuery(String phone);
}
