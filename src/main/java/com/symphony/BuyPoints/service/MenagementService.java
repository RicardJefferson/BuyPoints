package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.DefaultStoreSportChartDTO;
import com.symphony.BuyPoints.dto.MenagementDTO;
import com.symphony.BuyPoints.dto.MenagementOutputDTO;
import com.symphony.BuyPoints.model.DefaultStoreSportChart;
import com.symphony.BuyPoints.model.Menagement;

import java.util.List;

public interface MenagementService {

/*    DefaultStoreSportChartDTO getDefaultChart(int sportId, int storeId);*/

    /*DefaultStoreSportChartDTO getDefaultChart(Integer sportId, Integer storeId);*/

/*    DefaultStoreSportChart createDefaultChart(DefaultStoreSportChartDTO defaultStoreSportChartDTO);*/

    List<Menagement> createGameChart(List<MenagementDTO> menagementDTOs);

    MenagementOutputDTO getMenagement(int sportId, int storeId,
                                      int periodId, int lineTypeId);

}
