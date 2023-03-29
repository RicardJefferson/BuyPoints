package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.DefaultStoreSportChartDTO;
import com.symphony.BuyPoints.dto.EntityChartDTO;
import com.symphony.BuyPoints.dto.EntityInputDto;
import com.symphony.BuyPoints.dto.EntityOutputDTO;
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
    public EntityOutputDTO getEntities(int sportId, int storeId,
                                       int periodId, int lineTypeId) {

        DefaultStoreSportChartDTO d = null;
        List<EntityChartDTO> entityChartDTOS =
                entityRepository.getEntities(sportId, storeId, periodId, lineTypeId);

        Optional<DefaultStoreSportChart> defaultStoreSportChart =
                defaultChartRepository.findBySportIdAndStoreId(sportId, storeId);
        if (defaultStoreSportChart.isPresent()) {
            d = dtoConverter.convertToDefaultChartDTO(defaultStoreSportChart.get());
        }

        return EntityOutputDTO.builder()
                .defaultChartDTO(d)
                .entityDTOs(entityChartDTOS)
                .build();
    }

    @Override
    public EntityOutputDTO createEntity(EntityInputDto entityDTO) {

        DefaultStoreSportChart d = saveDefaultChart(entityDTO);
        List<EntityChart> entityCharts =
                (List<EntityChart>) entityChartRepository.saveAll(dtoConverter.convertToEntity(entityDTO));

        return EntityOutputDTO.builder()
                .defaultChartDTO(dtoConverter.convertToDefaultChartDTO(d))
                .entityDTOs(dtoConverter.convertToChartEntityDTO(entityCharts))
                .build();
    }

    private DefaultStoreSportChart saveDefaultChart(EntityInputDto entityDTO) {
        if (entityDTO.getDefaultChartDTO() != null) {
            Optional<DefaultStoreSportChart> defaultChartOptional = checkIfDefaultChartExists(entityDTO.getDefaultChartDTO());
            if (defaultChartOptional.isPresent()) {
                DefaultStoreSportChart d = defaultChartOptional.get();
                d.setChartId(entityDTO.getDefaultChartDTO().getChartId());
                d.setChartName(entityDTO.getDefaultChartDTO().getChartName());
                return defaultChartRepository.save(d);
            } else {
                return defaultChartRepository.save(dtoConverter.convertToDefaultChartEntity(entityDTO.getDefaultChartDTO()));
            }
        }
        return null;
    }

    private Optional<DefaultStoreSportChart> checkIfDefaultChartExists(DefaultStoreSportChartDTO defaultChartDTO) {
        return defaultChartRepository.findBySportIdAndStoreId(defaultChartDTO.getSportId(), defaultChartDTO.getStoreId());
    }

    @Override
    public List<EntityChart> updateEntity(EntityInputDto entityInputDto, Integer id) {
        return null;
    }

}
