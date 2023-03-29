package com.symphony.BuyPoints.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EntityOutputDTO {

    private DefaultStoreSportChartDTO defaultChartDTO;
    private List<EntityChartDTO> entityDTOs;
}
