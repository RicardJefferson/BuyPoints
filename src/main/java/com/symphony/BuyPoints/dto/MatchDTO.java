package com.symphony.BuyPoints.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MatchDTO {

    private Long id;
    private Long matchChartId;
    private Long marketId;
    private String marketName;
    private Long chartId;
    private String chartName;

    /* private List<MatchDTO> matchDTO;
     */

}
