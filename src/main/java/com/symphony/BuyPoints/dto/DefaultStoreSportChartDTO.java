package com.symphony.BuyPoints.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DefaultStoreSportChartDTO {

    public DefaultStoreSportChartDTO(Integer storeId, Integer sportId, Integer chartId) {
        this.storeId = storeId;
        this.sportId = sportId;
        this.chartId = chartId;
    }

    private Integer storeId;
    private Integer sportId;
    private Integer chartId;
    private SportDTO sport;
    private ChartDTO chart;

}
