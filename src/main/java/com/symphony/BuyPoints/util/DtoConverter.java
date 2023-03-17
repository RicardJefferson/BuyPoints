package com.symphony.BuyPoints.util;

import com.symphony.BuyPoints.dto.*;
import com.symphony.BuyPoints.model.*;
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

    public ChartDTO convertToChartDto(Chart chart) {

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

    public List<ChartDTO> convertToChartDto(List<Chart> charts) {
        return charts.stream()
                .map(chart -> convertToChartDto(chart))
                .collect(Collectors.toList());
    }

    public Chart convertToChartEntity(ChartDTO chartDto) {

        Chart chart = modelMapper.map(chartDto, Chart.class);

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

    /*public List<Chart> convertToChartEntity(List<ChartDTO> chartsDTO) {
        return chartsDTO.stream()
                .map(chartDTO -> convertToChartEntity(chartDTO))
                .collect(Collectors.toList());
    }*/

    public List<SportDTO> convertToSportDTO(List<Sport> sports) {
        List<SportDTO> sportDTOs = null;
        if (sports != null) {
            sportDTOs = sports.stream()
                    .map(sport -> convertToSportDTO(sport))
                    .collect(Collectors.toList());
        }
        return sportDTOs;
    }

    public SportDTO convertToSportDTO(Sport sport) {
        return new SportDTO(sport.getId(), sport.getName(),
                convertToPeriodDto(sport.getSportPeriods()), convertToLeagueDto(sport.getLeagues()));
    }

    private List<LeagueDTO> convertToLeagueDto(List<League> leagues) {
        return leagues.stream()
                .map(league -> {
                    LeagueDTO dto = modelMapper.map(league, LeagueDTO.class);
                    dto.setCountryDTO(convertToCountryDto(league.getCountry()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    private CountryDTO convertToCountryDto(Country country) {
        return modelMapper.map(country, CountryDTO.class);
    }

    private List<PeriodDTO> convertToPeriodDto(List<Period> sportPeriods) {
        return sportPeriods.stream()
                .map(period -> {
                    return modelMapper.map(period, PeriodDTO.class);
                })
                .collect(Collectors.toList());

    }

   /* public List<String> getPeriodNames(List<Period> periods) {
        return periods.stream()
                .map(Period::getPeriodName)
                .collect(Collectors.toList());
    }*/

    public DefaultStoreSportChart convertToMenagmentEntity(DefaultStoreSportChartDTO dDto) {
        /*return modelMapper.map(dDto, DefaultStoreSportChart.class);*/
        return DefaultStoreSportChart.builder()
                .sportId(dDto.getSportId())
                .chartId(dDto.getChartId())
                .storeId(dDto.getStoreId())
                .periodId(dDto.getPeriodId())
                .lineTypeId(dDto.getLineTypeId())
                .build();
    }

    public DefaultStoreSportChartDTO convertToMenagmentDTO(DefaultStoreSportChart d) {
        DefaultStoreSportChartDTO dto = modelMapper.map(d, DefaultStoreSportChartDTO.class);
        return dto;
    }
}
