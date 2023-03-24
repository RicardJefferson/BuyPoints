package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.MatchDTO;
import com.symphony.BuyPoints.repository.MatchRepository;
import com.symphony.BuyPoints.service.MatchService;
import com.symphony.BuyPoints.util.DtoConverter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final DtoConverter dtoConverter;

    @Override
    public List<MatchDTO> getMatchesByRotatingNumber(int rotationNumber) {
        return matchRepository.findByRotationNumber(rotationNumber)
                .map(matches -> dtoConverter.convertToMatchDTO(matches))
                .orElseThrow(() -> new NotFoundException("Match didn't found by rotation number" + rotationNumber));
    }
}
