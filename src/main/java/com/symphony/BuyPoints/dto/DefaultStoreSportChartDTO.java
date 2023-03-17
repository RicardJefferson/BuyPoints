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

    private Integer lineTypeId;
    private Integer periodId;
    private Integer storeId;
    private Integer sportId;
    private Integer chartId;
    private SportDTO sport;
    private ChartDTO chart;

}
