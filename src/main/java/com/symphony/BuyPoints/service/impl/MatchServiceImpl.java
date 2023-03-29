package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.MatchDTO;
import com.symphony.BuyPoints.dto.MatchOutputDTO;
import com.symphony.BuyPoints.model.Match;
import com.symphony.BuyPoints.repository.MatchRepository;
import com.symphony.BuyPoints.service.MatchService;
import com.symphony.BuyPoints.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final DtoConverter dtoConverter;

    /*@Override
    public List<MatchDTO> getMatchesByRotatingNumber(int rotationNumber) {
        return matchRepository.findByRotationNumber(rotationNumber)
                .map(matches -> dtoConverter.convertToMatchDTO(matches))
                .orElseThrow(() -> new NotFoundException("Match didn't found by rotation number" + rotationNumber));
    }*/

    @Override
    public MatchOutputDTO getMatch(int matchId, int sportId, int storeId, int lineTypeId, int periodId) {
        Optional<List<Match>> matchesOptional =
                matchRepository.findByMatchIdAndSportIdAndStoreIdAndLineTypeIdAndPeriodId(
                matchId, sportId, storeId, lineTypeId, periodId);

        if (matchesOptional.isPresent())
            return dtoConverter.convertToMatchDTO(matchesOptional.get());

        return null;


    }

    @Override
    public List<Match> createMatch(MatchOutputDTO matchOutputDTO) {
        return (List<Match>) matchRepository.saveAll(dtoConverter.convertToMatchEntity(matchOutputDTO));
    }
}
