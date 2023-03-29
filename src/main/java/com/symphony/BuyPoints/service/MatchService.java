package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.MatchDTO;
import com.symphony.BuyPoints.dto.MatchOutputDTO;
import com.symphony.BuyPoints.model.Match;

import java.util.List;


public interface MatchService {

    /*List<MatchDTO> getMatchesByRotatingNumber(int matchId);*/

    MatchOutputDTO getMatch(int match_id, int sportId, int storeId, int lineTypeId, int periodId);

    public List<Match> createMatch(MatchOutputDTO matchOutputDTO);
}
