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

    private Integer storeId;
    private Integer entityId;
    private Integer entityTypeId;
    private Integer sportId;
    private Integer lineTypeId;
    private Integer periodId;
    private Integer matchId;
    private List<MatchDTO> matchDTOList;


}
