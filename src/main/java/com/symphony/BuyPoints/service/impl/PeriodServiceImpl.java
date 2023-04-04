package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.PeriodDTO;
import com.symphony.BuyPoints.dto.SportDTO;
import com.symphony.BuyPoints.model.Period;
import com.symphony.BuyPoints.model.Sport;
import com.symphony.BuyPoints.repository.PeriodRepository;
import com.symphony.BuyPoints.service.PeriodService;
import com.symphony.BuyPoints.service.SportService;
import com.symphony.BuyPoints.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PeriodServiceImpl implements PeriodService {

    private final PeriodRepository periodRepository;
    private final DtoConverter dtoConverter;

    @Override
    public List<PeriodDTO> getPeriods() {
        Set<Period> set = new HashSet<>((List) periodRepository.findAll());
        return dtoConverter.convertToPeriodDto(set);
    }

    @Override
    public void removeAll(Set<Period> periods) {
        periodRepository.deleteAll(periods);
    }

    @Override
    public Optional<Period> findById(int id) {
        return periodRepository.findById(id);
    }

    @Override
    public void saveAll(Set<Period> periodSet) {
        periodRepository.saveAll(periodSet);
    }

    /*@Override
    public List<SportDTO> updateSportPeriods(SportDTO sportDTO) {
        Sport sport = sportService.getSportEntity(sportDTO.getId());
        *//*sport.removeAllPeriods(sport.getSportPeriods());*//*
        for(Period p: sport.getSportPeriods()){
            p.removeSport(sport);
        }
        periodRepository.save();
        return getAllSports();


    }*/
}
