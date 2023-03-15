package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.ChartDTO;
import com.symphony.BuyPoints.exception.custom.ChartNameExistsException;
import com.symphony.BuyPoints.model.Chart;
import com.symphony.BuyPoints.repository.ChartRepository;
import com.symphony.BuyPoints.service.ChartService;
import com.symphony.BuyPoints.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChartServiceImpl implements ChartService {

    private final ChartRepository chartRepository;

    private final DtoConverter dtoConverter;

    @Override
    public ChartDTO getChart(int id) {
        Chart chart = chartRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Chart with given id is not found"));
        return dtoConverter.convertToDto(chart);
    }

    @Override
    public List<ChartDTO> getAllActiveCharts() {
        List<Chart> charts = chartRepository.findByStatusTrue();
        return dtoConverter.convertToDto(charts);
    }

    @Override
    public Chart createChart(ChartDTO chartDTO) {
        chartRepository.findByName(chartDTO.getName())
                .ifPresent(chart -> {
                    throw new ChartNameExistsException(chartDTO.getName());
                });

        Chart chart = dtoConverter.convertToEntity(chartDTO);
        return chartRepository.save(chart);
    }

    @Override
    public Chart updateChart(ChartDTO chartDTO, Integer id) {
        chartRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Chart with given id is not found"));

        Chart updatedChart = dtoConverter.convertToEntity(chartDTO);
        updatedChart.setId(id);

        return chartRepository.save(updatedChart);
    }
}
