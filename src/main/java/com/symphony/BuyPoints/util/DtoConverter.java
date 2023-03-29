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

    public ChartDTO convertToChartDto(Chart chart) {
        return new ChartDTO(chart.getId(), convertItemsToDTOs(chart.getItems()),
                convertPointsRatioToDTOs(chart.getChartPointsRatio()), chart.getName(), chart.getEndingPoint());
    }

    public List<ChartItemDTO> convertItemsToDTOs(List<ChartItem> chartItems) {
        return chartItems.stream()
                .map(chartItem -> new ChartItemDTO(chartItem.getNumber(), chartItem.getPrice()))
                .collect(Collectors.toList());
    }

    public List<ChartPointsRatioDTO> convertPointsRatioToDTOs(List<ChartPointsRatio> chartPointsRatios) {
        return chartPointsRatios.stream()
                .map(chartPointsRatio -> new ChartPointsRatioDTO(chartPointsRatio.getOnPoint(), chartPointsRatio.getOnRatio(), chartPointsRatio.getOffPoint(), chartPointsRatio.getOffRatio()))
                .collect(Collectors.toList());
    }

    public List<ChartDTO> convertToChartDto(List<Chart> charts) {
        return charts.stream()
                .map(this::convertToChartDto)
                .collect(Collectors.toList());
    }

    public Chart convertToChartEntity(ChartDTO chartDto) {

        Chart chart = modelMapper.map(chartDto, Chart.class);

        if (chart.getChartPointsRatio() != null) {
            List<ChartPointsRatio> chartPointsRatios = chart.getChartPointsRatio().stream()
                    .peek(chartPointsRatio -> chartPointsRatio.setChart(chart))
                    .collect(Collectors.toList());

            chart.setChartPointsRatio(chartPointsRatios);
        }
        if (chart.getItems() != null) {
            List<ChartItem> items = chart.getItems().stream()
                    .peek(item -> item.setChart(chart))
                    .collect(Collectors.toList());

            chart.setItems(items);
        }

        return chart;
    }

    public List<SportDTO> convertToSportDTO(List<Sport> sports) {
        List<SportDTO> sportDTOs = null;
        if (sports != null) {
            sportDTOs = sports.stream()
                    .map(this::convertToSportDTO)
                    .collect(Collectors.toList());
        }
        return sportDTOs;
    }

    public SportDTO convertToSportDTO(Sport sport) {
        return SportDTO.builder()
                .id(sport.getId())
                .name(sport.getName())
                .sportPeriods(convertToPeriodDto(sport.getSportPeriods()))
                .marketDTOs(convertToMarketDTO(sport.getMarkets()))
                .build();
    }

    private List<MarketDTO> convertToMarketDTO(List<Market> markets) {
        return markets.stream()
                .map(this::convertToMarketDTO)
                .collect(Collectors.toList());
    }

    private MarketDTO convertToMarketDTO(Market market) {
        return MarketDTO.builder()
                .id(market.getId())
                .displayName(market.getName())
                .build();
    }

    public List<PeriodDTO> convertToPeriodDto(List<Period> sportPeriods) {
        return sportPeriods.stream()
                .map(period -> modelMapper.map(period, PeriodDTO.class))
                .collect(Collectors.toList());

    }

    public DefaultStoreSportChartDTO convertToDefaultChartDTO(DefaultStoreSportChart d) {
        return modelMapper.map(d, DefaultStoreSportChartDTO.class);
    }

    public DefaultStoreSportChart convertToDefaultChartEntity(DefaultStoreSportChartDTO defaultDTO) {
        return DefaultStoreSportChart.builder()
                .storeId(defaultDTO.getStoreId())
                .sportId(defaultDTO.getSportId())
                .chartId(defaultDTO.getChartId())
                .chartName(defaultDTO.getChartName())
                .build();
    }


    public List<EntityChart> convertToEntity(EntityInputDto entityInputDTO) {
        return entityInputDTO.getEntityDTOs().stream()
                .map(dto -> convertToEntity(entityInputDTO, dto))
                .collect(Collectors.toList());
    }

    private EntityChart convertToEntity(EntityInputDto entityInputDTO, EntityDTO entityDTO) {

        return EntityChart.builder()
                .storeId(entityInputDTO.getStoreId())
                .entityId(entityInputDTO.getEntityId())
                .entityTypeId(entityInputDTO.getEntityTypeId())
                .sportId(entityInputDTO.getSportId())
                .periodId(entityInputDTO.getPeriodId())
                .lineTypeId(entityInputDTO.getLineTypeId())
                .marketId(entityDTO.getMarketId())
                .marketName(entityDTO.getMarketName())
                .chartId(entityDTO.getChartId())
                .chartName(entityDTO.getChartName())
                .build();
    }

   /* public MatchOutputDTO convertToEntityDTO(List<ManagementEntity> entities) {

        List<MatchDTO> matchesDTOs = entities.stream()
                .map(this::convertToMatchDTO)
                .collect(Collectors.toList());

        return MatchOutputDTO.builder()
                .matchId(matches.get(0).getMatchId())
                .entityId(matches.get(0).getEntityId())
                .entityTypeId(matches.get(0).getEntityTypeId())
                .storeId(matches.get(0).getStoreId())
                .sportId(matches.get(0).getSportId())
                .lineTypeId(matches.get(0).getLineTypeId())
                .periodId(matches.get(0).getPeriodId())
                .matchDTOList(matchesDTOs)
                .build();


    }*/

    public Match convertToMatchEntity(MatchOutputDTO matchOutputDTO, MatchDTO matchDTO) {
        return Match.builder()
                .matchId(matchOutputDTO.getMatchId())
                .storeId(matchOutputDTO.getStoreId())
                .entityId(matchOutputDTO.getEntityId())
                .entityTypeId(matchOutputDTO.getEntityTypeId())
                .sportId(matchOutputDTO.getSportId())
                .periodId(matchOutputDTO.getPeriodId())
                .lineTypeId(matchOutputDTO.getLineTypeId())
                .marketId(matchDTO.getMarketId())
                .marketName(matchDTO.getMarketName())
                .chartId(matchDTO.getChartId())
                .chartName(matchDTO.getChartName())
                .build();

    }

    public MatchDTO convertToMatchDTO(Match match) {
        return MatchDTO.builder()
                .marketId(match.getMarketId())
                .marketName(match.getMarketName())
                .chartId(match.getChartId())
                .chartName(match.getChartName())
                .build();
    }

    public List<Match> convertToMatchEntity(MatchOutputDTO matchOutputDTO) {
        return matchOutputDTO.getMatchDTOList().stream()
                .map(matchDTO -> convertToMatchEntity(matchOutputDTO, matchDTO))
                .collect(Collectors.toList());
    }
    public MatchOutputDTO convertToMatchDTO(List<Match> matches) {

        List<MatchDTO> matchesDTOs = matches.stream()
                .map(this::convertToMatchDTO)
                .collect(Collectors.toList());

        return MatchOutputDTO.builder()
                .matchId(matches.get(0).getMatchId())
                .entityId(matches.get(0).getEntityId())
                .entityTypeId(matches.get(0).getEntityTypeId())
                .storeId(matches.get(0).getStoreId())
                .sportId(matches.get(0).getSportId())
                .lineTypeId(matches.get(0).getLineTypeId())
                .periodId(matches.get(0).getPeriodId())
                .matchDTOList(matchesDTOs)
                .build();
    }

    public List<EntityChartDTO> convertToChartEntityDTO(List<EntityChart> entityCharts) {
        return entityCharts.stream()
                .map(entityChart -> convertToChartEntityDTO(entityChart))
                .collect(Collectors.toList());
    }

    private EntityChartDTO convertToChartEntityDTO(EntityChart entityChart) {
        return EntityChartDTO.builder()
                .entityId(entityChart.getEntityId())
                .entityTypeId(entityChart.getEntityTypeId())
                .marketId(entityChart.getMarketId())
                .marketName(entityChart.getMarketName())
                .chartId(entityChart.getChartId())
                .chartName(entityChart.getChartName())
                .build();
    }
}
