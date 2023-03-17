package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.ChartDTO;
import com.symphony.BuyPoints.dto.DefaultStoreSportChartDTO;
import com.symphony.BuyPoints.dto.SportDTO;
import com.symphony.BuyPoints.model.DefaultStoreSportChart;
import com.symphony.BuyPoints.model.Sport;
import com.symphony.BuyPoints.repository.MenagmentRepository;
import com.symphony.BuyPoints.service.ChartService;
import com.symphony.BuyPoints.service.MenagmentService;
import com.symphony.BuyPoints.service.SportService;
import com.symphony.BuyPoints.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MenagmentServiceImpl implements MenagmentService {

    private final MenagmentRepository menagmentRepository;
    private final SportService sportService;
    private final ChartService chartService;
    private final DtoConverter dtoConverter;

    /*@Override
    public DefaultStoreSportChartDTO getDefaultChart(int sportId, int storeId) {
        DefaultStoreSportChartDTO dto = null;
        Optional<DefaultStoreSportChart> wrapperOptional = menagmentRepository.findBySportIdAndStoreId(sportId, storeId);
        if (wrapperOptional.isPresent()) {
            dto = dtoConverter.convertToMenagmentDTO(wrapperOptional.get());
        }
        return dto;
    }*/

    @Override
    public DefaultStoreSportChartDTO getDefaultChart(Integer sportId, Integer storeId,
                                                     Integer lineTypeId, Integer periodId) {
        DefaultStoreSportChartDTO dto = null;
        Optional<DefaultStoreSportChart> wrapperOptional = menagmentRepository.findBySportIdAndStoreIdAndLineTypeIdAndPeriodId(sportId, storeId, lineTypeId, periodId);

        if (wrapperOptional.isPresent()) {
            DefaultStoreSportChart wrapper = wrapperOptional.get();
            SportDTO sportDTO = sportService.getSport(wrapper.getSportId());
            ChartDTO chartDTO = chartService.getChart(wrapper.getChartId());
            dto = dtoConverter.convertToMenagmentDTO(wrapperOptional.get());
            dto.setChart(chartDTO);
            dto.setSport(sportDTO);
        }
        return dto;
    }

    @Override
    public DefaultStoreSportChart create(DefaultStoreSportChartDTO dto) {
        return menagmentRepository.save(dtoConverter.convertToMenagmentEntity(dto));
    }
}
