package com.symphony.BuyPoints.util;

import com.symphony.BuyPoints.dto.ChartDTO;
import com.symphony.BuyPoints.dto.ChartItemDTO;
import com.symphony.BuyPoints.dto.ChartPointsRatioDTO;
import com.symphony.BuyPoints.model.Chart;
import com.symphony.BuyPoints.model.ChartItem;
import com.symphony.BuyPoints.model.ChartPointsRatio;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class DtoConverter {

    private final ModelMapper modelMapper;

   /* public ChartDTO convertToDto(Chart chart) {
        ChartDTO chartDTO = modelMapper.map(chart, ChartDTO.class);
        return chartDTO;
    }*/

    public ChartDTO convertToDto(Chart chart) {

        ChartDTO chartDTO = new ChartDTO(convertItemsToDTOs(chart.getItems()),
                convertPointsRatioToDTOs(chart.getChartPointsRatio()), chart.getName(), chart.getEndingPoint());
        return chartDTO;
    }

    public List<ChartItemDTO> convertItemsToDTOs(List<ChartItem> chartItems) {
        return chartItems.stream()
                .map(chartItem -> {
                    return new ChartItemDTO(chartItem.getNumber(), chartItem.getPrice());
                })
                .collect(Collectors.toList());

    }

    public List<ChartPointsRatioDTO> convertPointsRatioToDTOs(List<ChartPointsRatio> chartPointsRatios) {
        return chartPointsRatios.stream()
                .map(chartPointsRatio -> {
                    return new ChartPointsRatioDTO(chartPointsRatio.getOnPoint(), chartPointsRatio.getOnRatio(), chartPointsRatio.getOffPoint(), chartPointsRatio.getOffRatio());
                })
                .collect(Collectors.toList());

    }

    public List<ChartDTO> convertToDto(List<Chart> charts) {
        return charts.stream()
                .map(chart -> convertToDto(chart))
                .collect(Collectors.toList());
    }

    public Chart convertToEntity(ChartDTO chartDto) {

        Chart chart = modelMapper.map(chartDto, Chart.class);

        /*Chart chart = new Chart(chartDto.getName(), chartDto.getEndingPoint(), true, chartDto.getUser());*/

        if (chart.getChartPointsRatio() != null) {
            List<ChartPointsRatio> chartPointsRatios = chart.getChartPointsRatio().stream()
                    .map(chartPointsRatio -> {
                        chartPointsRatio.setChart(chart);
                        return chartPointsRatio;
                    })
                    .collect(Collectors.toList());

            chart.setChartPointsRatio(chartPointsRatios);
        }

        if (chart.getItems() != null) {
            List<ChartItem> items = chart.getItems().stream()
                    .map(item -> {
                        item.setChart(chart);
                        return item;
                    })
                    .collect(Collectors.toList());

            chart.setItems(items);
        }

        return chart;
    }

    public List<Chart> convertToEntity(List<ChartDTO> chartsDTO) {
        return chartsDTO.stream()
                .map(chartDTO -> convertToEntity(chartDTO))
                .collect(Collectors.toList());
    }

}
