package com.symphony.BuyPoints.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MatchDTO {
    private Integer marketId;
    private String marketName;
    private Integer chartId;
    private String chartName;

    /* private List<MatchDTO> matchDTO;
     */

}
