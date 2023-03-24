package com.symphony.BuyPoints.service;

import com.symphony.BuyPoints.dto.ManagementDTO;
import com.symphony.BuyPoints.dto.ManagementOutputDTO;
import com.symphony.BuyPoints.model.Management;

import java.util.List;

public interface ManagementService {

/*    DefaultStoreSportChartDTO getDefaultChart(int sportId, int storeId);*/

    /*DefaultStoreSportChartDTO getDefaultChart(Integer sportId, Integer storeId);*/

/*    DefaultStoreSportChart createDefaultChart(DefaultStoreSportChartDTO defaultStoreSportChartDTO);*/

    List<Management> createGameChart(List<ManagementDTO> managementDTOS);

    ManagementOutputDTO getManagement(int sportId, int storeId,
                                      int periodId, int lineTypeId);

}
