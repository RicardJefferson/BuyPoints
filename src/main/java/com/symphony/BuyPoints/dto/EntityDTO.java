package com.symphony.BuyPoints.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntityDTO {
    private Long marketId;
    private String marketName;
    private Long chartId;
    private String chartName;

}
