package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.SportDTO;
import com.symphony.BuyPoints.model.Sport;
import com.symphony.BuyPoints.repository.SportRepository;
import com.symphony.BuyPoints.service.SportService;
import com.symphony.BuyPoints.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SportServiceImpl implements SportService {

    private final SportRepository sportRepository;
    private final DtoConverter dtoConverter;

    @Override
    public List<SportDTO> getAllSports() {
        return dtoConverter.convertToSportDTO(sportRepository.findAll());
    }

    @Override
    public SportDTO getSport(int id) {
        Sport sport = getSportEntity(id);
        return dtoConverter.convertToSportDTO(sport);
    }

    @Override
    public Sport getSportEntity(int id) {
        Sport sport = sportRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sport not found by given id " + id));
        return sport;
    }

}
