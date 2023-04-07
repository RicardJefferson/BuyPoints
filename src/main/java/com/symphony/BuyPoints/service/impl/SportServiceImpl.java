package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.dto.PeriodDTO;
import com.symphony.BuyPoints.dto.SportDTO;
import com.symphony.BuyPoints.model.Period;
import com.symphony.BuyPoints.model.Sport;
import com.symphony.BuyPoints.repository.SportRepository;
import com.symphony.BuyPoints.service.PeriodService;
import com.symphony.BuyPoints.service.SportService;
import com.symphony.BuyPoints.util.DtoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class SportServiceImpl implements SportService {

    private final SportRepository sportRepository;

    private final PeriodService periodService;
    private final DtoConverter dtoConverter;

    @Override
    public List<SportDTO> getAllSports() {
        return dtoConverter.convertToSportDTO(sportRepository.findAll());
    }

    @Override
    public SportDTO getSport(long id) {
        Sport sport = getSportEntity(id);
        return dtoConverter.convertToSportDTO(sport);
    }

    @Override
    public Sport getSportEntity(long id) {
        Sport sport = sportRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sport not found by given id " + id));
        return sport;
    }

    @Transactional
    @Override
    public List<SportDTO> updateSportPeriods(SportDTO sportDTO) {
        Sport sport = getSportEntity(sportDTO.getId());

        sportRepository.removeSportPeriodsRelations(sportDTO.getId());

        sport.getSportPeriods().clear();
        for (PeriodDTO periodDTO : sportDTO.getSportPeriods()) {
            Period existingPeriod = periodService.findById(periodDTO.getId()).orElse(null);
            if (existingPeriod != null) {
                sport.getSportPeriods().add(existingPeriod);
            }
        }
        //Set<Period> periodSet = new HashSet<>();
        //sport.setPeriods(dtoConverter.convertToPeriodEntity(sportDTO));
     /*   for (PeriodDTO p : sportDTO.getSportPeriods()) {
            p.removeSport(sport);
            periodSet.add(p);
        }*/
        sportRepository.save(sport);

        return getAllSports();


    }

}
