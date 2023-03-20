package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.LeagueDTO;
import com.symphony.BuyPoints.model.League;
import com.symphony.BuyPoints.repository.LeagueRepository;
import com.symphony.BuyPoints.service.LeagueService;
import com.symphony.BuyPoints.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LeagueServiceImpl implements LeagueService {

    private final LeagueRepository leagueRepository;

    private final DtoConverter dtoConverter;

    @Override
    public List<LeagueDTO> search(String name, String countryName, Integer sportId) {

        return leagueRepository.search(name, countryName, sportId)
                .map(leagues -> dtoConverter.convertToLeagueDto(leagues))
                .orElse(null);

       /* List<League> leagues = leagueRepository.search(name, countryName, sportId);

        if (leagues != null) {
            return dtoConverter.convertToLeagueDto(leagues);
        }

        return null;*/

    }
}
