package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.EntityInputDto;
import com.symphony.BuyPoints.dto.TableOutputDTO;
import com.symphony.BuyPoints.model.EntityChart;
import com.symphony.BuyPoints.model.ManagementEntity;

import java.util.List;

public interface ManagementEntityService {

    List<ManagementEntity> findBySportId(int sportId);

    TableOutputDTO getEntities(int sportId, int storeId,
                               int periodId, int lineTypeId);

    TableOutputDTO createEntity(EntityInputDto entityDTO);

    List<EntityChart> updateEntity(EntityInputDto entityInputDto, Integer id);
}
