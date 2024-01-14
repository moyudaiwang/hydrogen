package com.element.hydrogen.service.map;

import com.element.hydrogen.dto.map.MapParam;
import com.element.hydrogen.entity.common.ResponseJson;

/**
 * @InterfaceName MapService
 * @Description TODO
 * @Author yanyu
 * @Date 2024/1/7 4:49
 * @Version 1.0
 */
public interface MapService {

    ResponseJson initMapMenu(MapParam mapParam);

    ResponseJson queryMapPoints(MapParam mapParam);

}
