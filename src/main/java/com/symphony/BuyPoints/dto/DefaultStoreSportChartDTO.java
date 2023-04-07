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

    private Long storeId;
    private Long sportId;
    private Long chartId;
    private String chartName;


}
