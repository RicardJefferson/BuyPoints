package com.symphony.BuyPoints.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntityChartDTO {

    private Integer marketId;
    private String marketName;
    private Integer chartId;
    private String chartName;

}
