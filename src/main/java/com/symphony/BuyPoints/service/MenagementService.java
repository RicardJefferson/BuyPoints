package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.DefaultStoreSportChartDTO;
import com.symphony.BuyPoints.model.DefaultStoreSportChart;
import com.symphony.BuyPoints.model.Game;
import com.symphony.BuyPoints.dto.GamesDTO;

import java.util.List;

public interface MenagementService {

/*    DefaultStoreSportChartDTO getDefaultChart(int sportId, int storeId);*/

    DefaultStoreSportChartDTO getDefaultChart(Integer sportId, Integer storeId);

    DefaultStoreSportChart createDefaultChart(DefaultStoreSportChartDTO defaultStoreSportChartDTO);

    List<Game> createGameChart(GamesDTO gamesDTO);

}
