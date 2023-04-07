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
public class MatchOutputDTO {

    private Long id;
    private Long storeId;
    private Long entityId;
    private Integer entityTypeId;
    private Long sportId;
    private Long lineTypeId;
    private Long periodId;
    private Long matchId;
    private List<MatchDTO> matchDTOList;


}
