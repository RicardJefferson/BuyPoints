package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.PeriodDTO;
import com.symphony.BuyPoints.dto.SportDTO;
import com.symphony.BuyPoints.model.Period;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PeriodService {
    List<PeriodDTO> getPeriods();

    void removeAll(Set<Period> periods);

    Optional<Period> findById(long id);

    void saveAll(Set<Period> periodSet);

    /*    List<SportDTO> updateSportPeriods(SportDTO sportDTO);*/

}
