package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.DefaultStoreSportChartDTO;
import com.symphony.BuyPoints.dto.LeagueOutputDTO;
import com.symphony.BuyPoints.dto.MenagementDTO;
import com.symphony.BuyPoints.dto.MenagementOutputDTO;
import com.symphony.BuyPoints.model.*;
import com.symphony.BuyPoints.repository.DefaultStoreSportChartRepository;
import com.symphony.BuyPoints.repository.LeagueRepository;
import com.symphony.BuyPoints.repository.MenagementRepository;
import com.symphony.BuyPoints.service.MenagementService;
import com.symphony.BuyPoints.service.SportService;
import com.symphony.BuyPoints.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MenagementServiceImpl implements MenagementService {

    private final DefaultStoreSportChartRepository defaultChartRepository;
    private final MenagementRepository menagementRepository;
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
    public List<Menagement> createGameChart(List<MenagementDTO> menagementDTOs) {
        return (List<Menagement>) menagementRepository.saveAll(dtoConverter.convertToMenagementEntity(menagementDTOs));
    }

    @Override
    public MenagementOutputDTO getMenagement(int sportId, int storeId,
                                             int periodId, int lineTypeId) {

        List<LeagueOutputDTO> leagueOutputDTOList = new ArrayList<>();

        Sport sport = sportService.getSportEntity(sportId);

        //Optional<List<GamesByLeague>> gamesByLeague = gamesByLeagueRepository.getGamesByLeague(sportId, storeId, periodId, lineTypeId);
        Optional<List<Menagement>> menagementOptional = menagementRepository.getLeagueGames(sportId, storeId, periodId, lineTypeId);
        //Optional<DefaultStoreSportChart> defaultChartOptional = defaultChartRepository.findBySportIdAndStoreId(sportId, storeId);

        //leagues
        List<Integer> leaguesWithGamesIDs = new ArrayList<>();
        DefaultStoreSportChart defaultStoreSportChart = null;
        if (menagementOptional.isPresent()) {
            List<Menagement> menagementList = menagementOptional.get();
            for (Menagement menagement : menagementList) {
                List<Game> games = menagement.getGames();
                if (games != null && !games.isEmpty()) {
                    LeagueOutputDTO leagueOutputDTO = dtoConverter.convertToLeagueOutputDto(games);
                    leagueOutputDTOList.add(leagueOutputDTO);
                    leaguesWithGamesIDs.add(leagueOutputDTO.getId());
                }
            }
            defaultStoreSportChart = menagementList.get(0).getDefaultChart();
        }
     /*   List<League> allLeaguesBySport = leagueRepository.findBySport_Id(sportId);*/
        for (League league : sport.getLeagues()) {
            if (!leaguesWithGamesIDs.contains(league.getId())) {
                LeagueOutputDTO leagueOutputDTO = dtoConverter.convertToLeagueOutputDto(league);
                leagueOutputDTOList.add(leagueOutputDTO);
            }
        }

        //default store-sport chart
        DefaultStoreSportChartDTO defaultDTO = dtoConverter.convertToDefaultChartDTO(defaultStoreSportChart);

        return MenagementOutputDTO.builder()
                .leagueOutputDTO(leagueOutputDTOList)
                .defaultChart(defaultDTO)
                .build();
    }
}
