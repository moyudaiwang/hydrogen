package com.element.hydrogen.service.book;

import com.element.hydrogen.entity.book.DonBookFlowEntity;
import com.element.hydrogen.entity.common.ResponseJson;

import java.util.List;

/**
 * @InterfaceName BookFlowService
 * @Description TODO
 * @Author yanyu
 * @Date 2022-02-01 05:49:45
 * @Version 1.0
 */
public interface BookFlowService {
    ResponseJson query(DonBookFlowEntity donBookFlowEntity);

    ResponseJson insert(DonBookFlowEntity donBookFlowEntity);

    ResponseJson update(DonBookFlowEntity donBookFlowEntity);

    ResponseJson delete(List<DonBookFlowEntity> donBookFlowEntityList);
}
