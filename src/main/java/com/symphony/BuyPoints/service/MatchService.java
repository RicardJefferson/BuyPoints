package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.MatchDTO;

import java.util.List;

public interface MatchService {

    List<MatchDTO> getMatchesByRotatingNumber(int matchId);

}
