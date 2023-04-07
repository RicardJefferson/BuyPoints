package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.EntityInputDto;
import com.symphony.BuyPoints.dto.EntityOutputDTO;
import com.symphony.BuyPoints.dto.TableOutputDTO;
import com.symphony.BuyPoints.model.ManagementEntity;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ManagementEntityService {

    List<ManagementEntity> findBySportId(long sportId);

    TableOutputDTO getEntities(long sportId, long storeId,
                               long periodId, long lineTypeId);

    TableOutputDTO createEntity(List<EntityInputDto> entityDTOList);

    PageImpl<EntityOutputDTO> searchLeague(long sportId, long storeId, long periodId,
                                           long lineTypeId, String displayName,
                                           String organizationName, Pageable pageable);

}
