package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.SportDTO;
import com.symphony.BuyPoints.model.Sport;

import java.util.List;

public interface SportService {

    List<SportDTO> getAllSports();

    SportDTO getSport(long id);

    Sport getSportEntity(long id);

    List<SportDTO> updateSportPeriods(SportDTO sportDTO);

}
