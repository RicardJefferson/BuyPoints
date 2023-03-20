package com.symphony.BuyPoints.util;

import com.symphony.BuyPoints.dto.*;
import com.symphony.BuyPoints.model.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class DtoConverter {

    private final ModelMapper modelMapper;

    public ChartDTO convertToChartDto(Chart chart) {

        ChartDTO chartDTO = new ChartDTO(chart.getId(), convertItemsToDTOs(chart.getItems()),
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

    public List<LeagueDTO> convertToLeagueDto(List<League> leagues) {
        return leagues.stream()
                .map(league -> {
                    LeagueDTO dto = modelMapper.map(league, LeagueDTO.class);
                    dto.setCountryDTO(convertToCountryDto(league.getCountry()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public CountryDTO convertToCountryDto(Country country) {
        return modelMapper.map(country, CountryDTO.class);
    }

    public List<PeriodDTO> convertToPeriodDto(List<Period> sportPeriods) {
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
        return DefaultStoreSportChart.builder()
                .sportId(dDto.getSportId())
                .chartId(dDto.getChartId())
                .storeId(dDto.getStoreId())
                .build();
    }

    public DefaultStoreSportChartDTO convertToMenagmentDTO(DefaultStoreSportChart d) {
        DefaultStoreSportChartDTO dto = modelMapper.map(d, DefaultStoreSportChartDTO.class);
        return dto;
    }

    public List<Game> convertToGameEntity(GamesDTO gamesDTO) {

        if (gamesDTO.getGameDTOs() != null) {
            return gamesDTO.getGameDTOs().stream()
                    .map(gameDTO -> {
                        return convertToGameEntity(gameDTO, gamesDTO);
                    })
                    .collect(Collectors.toList());
        } else {
            throw new InputMismatchException("");
        }



        /*League league = new League();
        league.setId(gDto.getLeague());

        Store store = new Store();
        store.setId(gDto.getStoreId());

        LineType lineType = new LineType();
        lineType.setId(gDto.getLineTypeId());

        Period period = new Period();
        period.setId(gDto.getPeriodId());

        Chart chart = new Chart();
        chart.setId(gDto.getChartId());

        return Game.builder()
                .league(league)
                .store(store)
                .lineType(lineType)
                .period(period)
                .chart(chart)
                .gameType(gDto.getGameType())
                .build();*/
    }

    private Game convertToGameEntity(GameDTO gameDTO, GamesDTO gamesDTO) {

        return Game.builder()
                .gameType(gameDTO.getGameType())
                .chartId(gameDTO.getChartId())
                .storeId(gamesDTO.getStoreId())
                .leagueId(gamesDTO.getLeagueId())
                .periodId(gamesDTO.getPeriodId())
                .lineTypeId(gamesDTO.getLineTypeId())
                .build();
    }

}
