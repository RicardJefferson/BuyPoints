package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.DefaultStoreSportChartDTO;
import com.symphony.BuyPoints.model.DefaultStoreSportChart;

public interface MenagmentService {

/*    DefaultStoreSportChartDTO getDefaultChart(int sportId, int storeId);*/

    DefaultStoreSportChartDTO getDefaultChart(Integer sportId, Integer storeId,
                                              Integer lineTypeId, Integer periodId);

    DefaultStoreSportChart create(DefaultStoreSportChartDTO defaultStoreSportChartDTO);

}
