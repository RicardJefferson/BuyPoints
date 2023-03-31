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
public class EntityOutputDTO {

    private Integer id;
    private Integer entityId;
    private Integer entityTypeId;
    @JsonProperty("Country/Source")
    private String displayName;
    @JsonProperty("League/Tournaments")
    private String organizationName;
    private List<EntityChartDTO> entityChartDTOs;

}
