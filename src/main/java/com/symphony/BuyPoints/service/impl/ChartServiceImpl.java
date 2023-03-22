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

@RequiredArgsConstructor
@Service
public class ChartServiceImpl implements ChartService {

    private final ChartRepository chartRepository;

    private final DtoConverter dtoConverter;

    @Override
    public ChartDTO getChart(int id) {
        Chart chart = chartRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Chart with given id is not found"));
        return dtoConverter.convertToChartDto(chart);
    }

    @Override
    public List<ChartDTO> getAllActiveCharts() {
        List<Chart> charts = chartRepository.findByStatusTrue();
        return dtoConverter.convertToChartDto(charts);
    }

  /*  @Override
    public List<ChartDTO> getChartsBySport() {
        return null;
        *//*List<Chart> charts = chartRepository.findAll();
        return dtoConverter.convertToChartDto(charts);*//*
    }*/

    @Override
    public Chart createChart(ChartDTO chartDTO) {
        chartRepository.findByName(chartDTO.getName())
                .ifPresent(chart -> {
                    throw new ChartNameExistsException(chartDTO.getName());
                });

        Chart chart = dtoConverter.convertToChartEntity(chartDTO);
        return chartRepository.save(chart);
    }

    @Override
    public Chart updateChart(ChartDTO chartDTO, Integer id) {
        chartRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Chart with given id is not found"));

        Chart updatedChart = dtoConverter.convertToChartEntity(chartDTO);
        updatedChart.setId(id);

        return chartRepository.save(updatedChart);
    }
}
