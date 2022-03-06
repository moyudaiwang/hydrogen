package com.element.hydrogen.service.graph;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.graph.DonHlmInfoEntity;

import java.util.List;

/**
 * @InterfaceName HlmInfoService
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-26 21:35:02
 * @Version 1.0
 */
public interface HlmInfoService {
    ResponseJson query(DonHlmInfoEntity donHlmInfoEntity);

    ResponseJson insert(DonHlmInfoEntity donHlmInfoEntity);

    ResponseJson update(DonHlmInfoEntity donHlmInfoEntity);

    ResponseJson delete(List<DonHlmInfoEntity> donHlmInfoEntityList);

}
