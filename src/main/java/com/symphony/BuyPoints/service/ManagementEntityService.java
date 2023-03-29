package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.EntityChartDTO;
import com.symphony.BuyPoints.dto.EntityInputDto;
import com.symphony.BuyPoints.dto.EntityOutputDTO;
import com.symphony.BuyPoints.model.EntityChart;
import com.symphony.BuyPoints.model.ManagementEntity;

import java.util.List;

public interface ManagementEntityService {

    List<ManagementEntity> findBySportId(int sportId);

    EntityOutputDTO getEntities(int sportId, int storeId,
                                int periodId, int lineTypeId);

    List<EntityChart> createEntity(EntityInputDto entityDTO);
}
