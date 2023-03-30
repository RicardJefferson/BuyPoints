package com.symphony.BuyPoints.dto;

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
    private String displayName;
    private String organizationName;
    private List<EntityChartDTO> entityChartDTOs;

}
