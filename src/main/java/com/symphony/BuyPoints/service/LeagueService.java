package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.LeagueDTO;

import java.util.List;

public interface LeagueService {

    List<LeagueDTO> search(String name, String countryName, Integer sportId);

}
