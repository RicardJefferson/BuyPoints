package com.symphony.BuyPoints.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntityInputDto {

    private DefaultStoreSportChartDTO defaultChartDTO;

    private Long id;
    private Long storeId;
    private Long entityId;
    private Integer entityTypeId;
    private Long sportId;
    private Long lineTypeId;
    private Long periodId;
    private List<EntityDTO> entityDTOs;

}
