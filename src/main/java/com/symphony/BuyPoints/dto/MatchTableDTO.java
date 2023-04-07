package com.symphony.BuyPoints.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchTableDTO {

    private Long id;
    private Long entityId;
    private Integer entityTypeId;
    @JsonProperty("League/Tournament")
    private String displayName;
    @JsonProperty("Country/Source")
    private String organizationName;
    private List<MatchDTO> matchChartDTOs;

}
