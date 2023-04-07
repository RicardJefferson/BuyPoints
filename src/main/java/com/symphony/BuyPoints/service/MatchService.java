package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.MatchDTO;
import com.symphony.BuyPoints.dto.MatchOutputDTO;
import com.symphony.BuyPoints.dto.MatchTableDTO;
import com.symphony.BuyPoints.model.Match;

import java.util.List;


public interface MatchService {

    /*List<MatchDTO> getMatchesByRotatingNumber(int matchId);*/

    MatchTableDTO getMatch(long entityId, long match_id, long sportId,
                           long storeId, long lineTypeId, long periodId);

    public MatchTableDTO createMatch(MatchOutputDTO matchOutputDTO);
}
