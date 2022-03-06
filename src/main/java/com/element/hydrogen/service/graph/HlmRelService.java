package com.element.hydrogen.service.graph;

import com.element.hydrogen.entity.common.ResponseJson;
import com.element.hydrogen.entity.graph.DonHlmRelEntity;

import java.util.List;

/**
 * @InterfaceName HlmRelService
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-26 22:07:28
 * @Version 1.0
 */
public interface HlmRelService {
    ResponseJson query(DonHlmRelEntity donHlmRelEntity);

    ResponseJson insert(DonHlmRelEntity donHlmRelEntity);

    ResponseJson update(DonHlmRelEntity donHlmRelEntity);

    ResponseJson delete(List<DonHlmRelEntity> donHlmRelEntityList);

}
