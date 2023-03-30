package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.*;
import com.symphony.BuyPoints.model.DefaultStoreSportChart;
import com.symphony.BuyPoints.model.EntityChart;
import com.symphony.BuyPoints.model.ManagementEntity;
import com.symphony.BuyPoints.repository.DefaultStoreSportChartRepository;
import com.symphony.BuyPoints.repository.EntityChartRepository;
import com.symphony.BuyPoints.repository.ManagementEntityRepository;
import com.symphony.BuyPoints.service.ManagementEntityService;
import com.symphony.BuyPoints.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    @Override
    public TableOutputDTO getEntities(int sportId, int storeId,
                                      int periodId, int lineTypeId) {

        DefaultStoreSportChartDTO d = null;
        List<ManagementEntity> entities =
                entityRepository.findBySport_Id(sportId);

        List<EntityOutputDTO> entityOutputDTOS =
                dtoConverter.convertToEntityDTO(entities, storeId, periodId, lineTypeId);

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

    @Override
    public TableOutputDTO createEntity(EntityInputDto entityDTO) {

        saveDefaultChart(entityDTO);

        entityChartRepository.saveAll(dtoConverter.convertToEntity(entityDTO));

        return getEntities(entityDTO.getSportId(), entityDTO.getStoreId(),
                entityDTO.getPeriodId(), entityDTO.getLineTypeId());
    }

    private void saveDefaultChart(EntityInputDto entityDTO) {
        if (entityDTO.getDefaultChartDTO() != null) {
            Optional<DefaultStoreSportChart> defaultChartOptional = findDefaultChart(entityDTO.getDefaultChartDTO());
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

    private Optional<DefaultStoreSportChart> findDefaultChart(DefaultStoreSportChartDTO defaultChartDTO) {
        return defaultChartRepository.findBySportIdAndStoreId(defaultChartDTO.getSportId(), defaultChartDTO.getStoreId());
    }

    @Override
    public List<EntityChart> updateEntity(EntityInputDto entityInputDto, Integer id) {
        return null;
    }

}
