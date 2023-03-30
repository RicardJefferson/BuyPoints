package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.MatchDTO;
import com.symphony.BuyPoints.dto.MatchOutputDTO;
import com.symphony.BuyPoints.dto.MatchTableDTO;
import com.symphony.BuyPoints.model.ManagementEntity;
import com.symphony.BuyPoints.model.Match;
import com.symphony.BuyPoints.repository.ManagementEntityRepository;
import com.symphony.BuyPoints.repository.MatchRepository;
import com.symphony.BuyPoints.service.MatchService;
import com.symphony.BuyPoints.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final ManagementEntityRepository entityRepository;
    private final DtoConverter dtoConverter;

    /*@Override
    public List<MatchDTO> getMatchesByRotatingNumber(int rotationNumber) {
        return matchRepository.findByRotationNumber(rotationNumber)
                .map(matches -> dtoConverter.convertToMatchDTO(matches))
                .orElseThrow(() -> new NotFoundException("Match didn't found by rotation number" + rotationNumber));
    }*/

    @Override
    public MatchTableDTO getMatch(int entityId, int matchId, int sportId, int storeId, int lineTypeId, int periodId) {

        List<MatchDTO> matchDTOList = new ArrayList<>();
        Optional<List<Match>> matchesOptional =
                matchRepository.findByMatchIdAndSportIdAndStoreIdAndLineTypeIdAndPeriodId(
                        matchId, sportId, storeId, lineTypeId, periodId);

        if (matchesOptional.isPresent()) {
            matchDTOList = dtoConverter.convertToMatchDTO(matchesOptional.get());
        }

        ManagementEntity m = entityRepository.findByEntityId(entityId);


        return MatchTableDTO.builder()
                .id(m.getId())
                .entityId(m.getEntityId())
                .entityTypeId(m.getEntityTypeId())
                .displayName(m.getDisplayName())
                .organizationName(m.getOrganizationName())
                .matchChartDTOs(matchDTOList)
                .build();


    }

    @Override
    public List<Match> createMatch(MatchOutputDTO matchOutputDTO) {
        return (List<Match>) matchRepository.saveAll(dtoConverter.convertToMatchEntity(matchOutputDTO));
    }
}
