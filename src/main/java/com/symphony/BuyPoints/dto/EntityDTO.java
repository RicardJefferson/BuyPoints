package com.symphony.BuyPoints.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntityDTO {
    private Integer marketId;
    private String marketName;
    private Integer chartId;
    private String chartName;

}
