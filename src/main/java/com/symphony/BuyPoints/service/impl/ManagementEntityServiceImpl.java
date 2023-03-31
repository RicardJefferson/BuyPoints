package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.*;
import com.symphony.BuyPoints.model.DefaultStoreSportChart;
import com.symphony.BuyPoints.model.EntityChart;
import com.symphony.BuyPoints.model.ManagementEntity;
import com.symphony.BuyPoints.model.Match;
import com.symphony.BuyPoints.repository.DefaultStoreSportChartRepository;
import com.symphony.BuyPoints.repository.EntityChartRepository;
import com.symphony.BuyPoints.repository.ManagementEntityRepository;
import com.symphony.BuyPoints.service.ManagementEntityService;
import com.symphony.BuyPoints.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ManagementEntityServiceImpl implements ManagementEntityService {

    private final DtoConverter dtoConverter;
    private final ManagementEntityRepository entityRepository;
    private final EntityChartRepository entityChartRepository;
    private final DefaultStoreSportChartRepository defaultChartRepository;


    @Override
    public List<ManagementEntity> findBySportId(int sportId) {
        return entityRepository.findBySport_Id(sportId);
    }

    @Transactional(readOnly = true)
    @Override
    public TableOutputDTO getEntities(int sportId, int storeId,
                                      int periodId, int lineTypeId) {

        DefaultStoreSportChartDTO d = null;
        List<EntityOutputDTO> entityOutputDTOS = new ArrayList<>();
        List<ManagementEntity> entities =
                entityRepository.findBySport_Id(sportId);

        for (ManagementEntity e : entities) {
            Optional<List<EntityChart>> entityChartsOptional =
                    entityChartRepository.getEntityChart(sportId, storeId, periodId,
                            lineTypeId, e.getEntityId(), e.getEntityTypeId());

            if (entityChartsOptional.isPresent())
                entityOutputDTOS.add(createEntityOutput(e, entityChartsOptional.get()));
        }

        Optional<DefaultStoreSportChart> defaultStoreSportChart =
                defaultChartRepository.findBySportIdAndStoreId(sportId, storeId);

        if (defaultStoreSportChart.isPresent()) {
            d = dtoConverter.convertToDefaultChartDTO(defaultStoreSportChart.get());
        }

        return TableOutputDTO.builder()
                .defaultChartDTO(d)
                .entityOutputDTOs(entityOutputDTOS)
                .build();
    }

    private EntityOutputDTO createEntityOutput(ManagementEntity entity, List<EntityChart> entityCharts) {
        EntityOutputDTO response = EntityOutputDTO.builder()
                .id(entity.getId())
                .entityTypeId(entity.getEntityTypeId())
                .entityId(entity.getEntityId())
                .displayName(entity.getDisplayName())
                .organizationName(entity.getOrganizationName())
                .build();

        List<EntityChartDTO> entityChartDTOs = new ArrayList<>();
        for (EntityChart ec : entityCharts) {
            entityChartDTOs.add(EntityChartDTO.builder()
                    .marketId(ec.getMarketId())
                    .marketName(ec.getMarketName())
                    .chartId(ec.getChartId())
                    .chartName(ec.getChartName())
                    .build());

        }
        response.setEntityChartDTOs(entityChartDTOs);
        return response;
    }

    @Transactional
    @Override
    public TableOutputDTO createEntity(List<EntityInputDto> entityDTOList) {

        for (EntityInputDto entityDTO : entityDTOList) {

            saveDefaultChart(entityDTO);

            Optional<List<EntityChart>> entityChartsOptional = entityChartRepository.getEntityChart(
                    entityDTO.getSportId(), entityDTO.getStoreId(),
                    entityDTO.getLineTypeId(), entityDTO.getPeriodId(),
                    entityDTO.getEntityId(), entityDTO.getEntityTypeId());

            if (entityChartsOptional.isPresent())
                entityChartRepository.deleteAll(entityChartsOptional.get());


            entityChartRepository.saveAll(dtoConverter.convertToEntity(entityDTO));
        }

        return getEntities(entityDTOList.get(0).getSportId(), entityDTOList.get(0).getStoreId(),
                entityDTOList.get(0).getPeriodId(), entityDTOList.get(0).getLineTypeId());
    }

    @Transactional
    private void saveDefaultChart(EntityInputDto entityDTO) {
        if (entityDTO.getDefaultChartDTO() != null) {
            Optional<DefaultStoreSportChart> defaultChartOptional = defaultChartRepository.
                    findBySportIdAndStoreId(entityDTO.getDefaultChartDTO().getSportId(), entityDTO.getDefaultChartDTO().getStoreId());
            if (defaultChartOptional.isPresent()) {
                DefaultStoreSportChart defaultChart = defaultChartOptional.get();
                if (defaultChart.getChartId() != entityDTO.getDefaultChartDTO().getChartId()) {
                    defaultChart.setChartId(entityDTO.getDefaultChartDTO().getChartId());
                    defaultChart.setChartName(entityDTO.getDefaultChartDTO().getChartName());
                    defaultChartRepository.save(defaultChart);
                }
            } else {
                defaultChartRepository.save(dtoConverter.convertToDefaultChartEntity(entityDTO.getDefaultChartDTO()));
            }
        }
    }

}
