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

    private Integer id;
    private Integer matchChartId;
    private Integer marketId;
    private String marketName;
    private Integer chartId;
    private String chartName;

    /* private List<MatchDTO> matchDTO;
     */

}
