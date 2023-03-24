package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.DefaultStoreSportChartDTO;
import com.symphony.BuyPoints.dto.LeagueOutputDTO;
import com.symphony.BuyPoints.dto.ManagementDTO;
import com.symphony.BuyPoints.dto.ManagementOutputDTO;
import com.symphony.BuyPoints.model.*;
import com.symphony.BuyPoints.repository.DefaultStoreSportChartRepository;
import com.symphony.BuyPoints.repository.LeagueRepository;
import com.symphony.BuyPoints.repository.ManagementRepository;
import com.symphony.BuyPoints.service.ManagementService;
import com.symphony.BuyPoints.service.SportService;
import com.symphony.BuyPoints.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ManagementServiceImpl implements ManagementService {

    private final DefaultStoreSportChartRepository defaultChartRepository;
    private final ManagementRepository managementRepository;
    private final LeagueRepository leagueRepository;
    /*    private final GamesByLeagueRepository gamesByLeagueRepository;*/
    private final SportService sportService;
    /*    private final ChartService chartService;*/
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

  /*  @Override
    public DefaultStoreSportChartDTO getDefaultChart(Integer sportId, Integer storeId) {
        DefaultStoreSportChartDTO dto = null;
        Optional<DefaultStoreSportChart> wrapperOptional = menagmentRepository.findBySportIdAndStoreId(sportId, storeId);

        if (wrapperOptional.isPresent()) {
            DefaultStoreSportChart wrapper = wrapperOptional.get();
            SportDTO sportDTO = sportService.getSport(wrapper.getSportId());
            dto = dtoConverter.convertToMenagmentDTO(wrapperOptional.get());
            dto.setSport(sportDTO);


            //ChartDTO chartDTO = chartService.getChart(wrapper.getChartId());
            //dto.setChart(chartDTO);

        }
        return dto;
    }*/

    /*@Override
    public DefaultStoreSportChart createDefaultChart(DefaultStoreSportChartDTO dto) {
        return menagmentRepository.save(dtoConverter.convertToMenagmentEntity(dto));
    }*/

    @Override
    public List<Management> createGameChart(List<ManagementDTO> managementDTOS) {
        return (List<Management>) managementRepository.saveAll(dtoConverter.convertToManagementEntity(managementDTOS));
    }

    @Override
    public ManagementOutputDTO getManagement(int sportId, int storeId,
                                             int periodId, int lineTypeId) {

        List<LeagueOutputDTO> leagueOutputDTOList = new ArrayList<>();
        DefaultStoreSportChartDTO defaultDTO = null;
        Sport sport = sportService.getSportEntity(sportId);
        Optional<List<Management>> managementOptional = managementRepository.getLeagueGames(sportId, storeId, periodId, lineTypeId);
        //Optional<List<GamesByLeague>> gamesByLeague = gamesByLeagueRepository.getGamesByLeague(sportId, storeId, periodId, lineTypeId);
        //Optional<DefaultStoreSportChart> defaultChartOptional = defaultChartRepository.findBySportIdAndStoreId(sportId, storeId);

        //leagues with custom charts mapping
        List<Integer> leaguesWithGamesIDs = new ArrayList<>();
        DefaultStoreSportChart defaultStoreSportChart = null;
        if (managementOptional.isPresent() && managementOptional.get().size() > 0) {
            List<Management> managementList = managementOptional.get();
            for (Management management : managementList) {
                List<Game> games = management.getGames();
                if (games != null && !games.isEmpty()) {
                    LeagueOutputDTO leagueOutputDTO = dtoConverter.convertToLeagueOutputDto(games);
                    leagueOutputDTOList.add(leagueOutputDTO);
                    leaguesWithGamesIDs.add(leagueOutputDTO.getId());
                }
            }
            //default store-sport chart
            defaultStoreSportChart = managementList.get(0).getDefaultChart();
            defaultDTO = dtoConverter.convertToDefaultChartDTO(defaultStoreSportChart);
        }
        //all others league mapping
        /*   List<League> allLeaguesBySport = leagueRepository.findBySport_Id(sportId);*/
        for (League league : sport.getLeagues()) {
            if (!leaguesWithGamesIDs.contains(league.getId())) {
                LeagueOutputDTO leagueOutputDTO = dtoConverter.convertToLeagueOutputDto(league);
                leagueOutputDTOList.add(leagueOutputDTO);
            }
        }

        return ManagementOutputDTO.builder()
                .leagueOutputDTO(leagueOutputDTOList)
                .defaultChart(defaultDTO)
                .build();
    }
}
