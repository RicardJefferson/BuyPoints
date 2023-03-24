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

/*    public DefaultStoreSportChart convertToMenagmentEntity(DefaultStoreSportChartDTO dDto) {
        return DefaultStoreSportChart.builder()
                .sportId(dDto.getSportId())
                .chartId(dDto.getChartId())
                .storeId(dDto.getStoreId())
                .build();
    }*/

    public DefaultStoreSportChartDTO convertToDefaultChartDTO(DefaultStoreSportChart d) {
        DefaultStoreSportChartDTO dto = modelMapper.map(d, DefaultStoreSportChartDTO.class);
        return dto;
    }

    public List<Management> convertToManagementEntity(List<ManagementDTO> managementDTOS) {
        if (managementDTOS != null && !managementDTOS.isEmpty()) {
            return managementDTOS.stream()
                    .map(managementDTO -> {
                        if (managementDTO.getGameDTOs() != null) {
                            return convertToManagementEntity(managementDTO);
                        } else {
                            throw new InputMismatchException("Bad input parameters");

                        }
                    }).collect(Collectors.toList());
        }

        return null;
    }

    private Management convertToManagementEntity(ManagementDTO managementDTO) {

        Management m = Management.builder()
                .storeId(managementDTO.getStoreId())
                .leagueId(managementDTO.getLeagueId())
                .sportId(managementDTO.getSportId())
                .periodId(managementDTO.getPeriodId())
                .lineTypeId(managementDTO.getLineTypeId())
                /* .games(convertToGameEntity(menagementDTO))*/
                .defaultChart(convertToDefaultChartEntity(managementDTO))
                .build();

        m.setGames(convertToGameEntity(managementDTO.getGameDTOs(), m));
        return m;
    }

    private DefaultStoreSportChart convertToDefaultChartEntity(ManagementDTO managementDTO) {
        return DefaultStoreSportChart.builder()
                .sportId(managementDTO.getSportId())
                .storeId(managementDTO.getStoreId())
                .sportId(managementDTO.getSportId())
                .chartId(managementDTO.getDefaultChart())
                .chartName(managementDTO.getDefaultChartName())
                .build();
    }

    private List<Game> convertToGameEntity(List<GameDTO> gamesDTO, Management management) {
        if (gamesDTO != null) {
            return gamesDTO
                    .stream()
                    .map(gameDTO -> {
                        return convertToGameEntity(gameDTO, management);
                    })
                    .collect(Collectors.toList());
        }
        return null;
    }

    private Game convertToGameEntity(GameDTO gameDTO, Management management) {
        League league = new League();
        league.setId(management.getLeagueId());
        return Game.builder()
                .gameType(gameDTO.getGameType())
                .chartId(gameDTO.getChartId())
                .chartName(gameDTO.getChartName())
                .menagement(management)
                .league(league)
                .build();
    }
    public LeagueOutputDTO convertToLeagueOutputDto(List<Game> games) {
        if (games != null && !games.isEmpty()) {

            List<GameDTO> gameDTOList = games.stream()
                    .map(game -> convertToGameDTO(game))
                    .collect(Collectors.toList());

            return LeagueOutputDTO.builder()
                    .id(games.get(0).getLeague().getId())
                    .leagueName(games.get(0).getLeague().getName())
                    .countryName(games.get(0).getLeague().getCountry().getName())
                    .games(gameDTOList)
                    .build();
        }
    return null;
    }

    private GameDTO convertToGameDTO(Game game) {
        return GameDTO.builder()
                .gameType(game.getGameType())
                .chartId(game.getChartId())
                .chartName(game.getChartName())
                .build();
    }

    public LeagueOutputDTO convertToLeagueOutputDto(League league) {
        return LeagueOutputDTO.builder()
                .id(league.getId())
                .leagueName(league.getName())
                .build();
    }

    public List<MatchDTO> convertToMatchDTO(List<Match> match) {
        return null;
    }
}
