package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.SportDTO;
import com.symphony.BuyPoints.model.Sport;

import java.util.List;
import java.util.Optional;

public interface SportService {

    List<SportDTO> getAllSports();

    SportDTO getSport(int id);

}
