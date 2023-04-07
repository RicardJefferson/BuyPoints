package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.ChartDTO;
import com.symphony.BuyPoints.model.Chart;

import java.util.List;

public interface ChartService {

    ChartDTO getChart(long id);

    List<ChartDTO> getAllActiveCharts();

   /* List<ChartDTO> getChartsBySport();*/

    Chart createChart(ChartDTO chartDTO);

    Chart updateChart(ChartDTO chartDTO, Long id);


}
