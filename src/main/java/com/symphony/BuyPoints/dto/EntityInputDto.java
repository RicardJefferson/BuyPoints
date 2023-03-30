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

    private Integer id;
    private Integer storeId;
    private Integer entityId;
    private Integer entityTypeId;
    private Integer sportId;
    private Integer lineTypeId;
    private Integer periodId;
    private List<EntityDTO> entityDTOs;

}
