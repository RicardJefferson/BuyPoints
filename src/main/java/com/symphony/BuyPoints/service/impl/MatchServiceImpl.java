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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final ManagementEntityRepository entityRepository;
    private final DtoConverter dtoConverter;

    @Transactional(readOnly = true)
    @Override
    public MatchTableDTO getMatch(long entityId, long matchId, long sportId, long storeId, long lineTypeId, long periodId) {

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

    @Transactional
    @Override
    public MatchTableDTO createMatch(MatchOutputDTO matchOutputDTO) {

        Optional<List<Match>> matchesOptional =
                matchRepository.findByMatchIdAndSportIdAndStoreIdAndLineTypeIdAndPeriodId(
                        matchOutputDTO.getMatchId(), matchOutputDTO.getSportId(),
                        matchOutputDTO.getStoreId(), matchOutputDTO.getLineTypeId(), matchOutputDTO.getPeriodId());

        if (matchesOptional.isPresent())
            deleteExistingEntityCharts(matchesOptional.get());


        matchRepository.saveAll(dtoConverter.convertToMatchEntity(matchOutputDTO));
        return getMatch(matchOutputDTO.getEntityId(), matchOutputDTO.getMatchId(),
                matchOutputDTO.getSportId(), matchOutputDTO.getLineTypeId(),
                matchOutputDTO.getStoreId(), matchOutputDTO.getPeriodId());
    }

    @Modifying
    @Transactional
    public void deleteExistingEntityCharts(List<Match> matches) {
        matchRepository.deleteAll(matches);
    }
}
