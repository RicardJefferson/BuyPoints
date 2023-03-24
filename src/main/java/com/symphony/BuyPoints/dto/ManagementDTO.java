package com.symphony.BuyPoints.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ManagementDTO {

    private Integer storeId;
    private Integer leagueId;
/*    private String leagueName;*/
    private Integer sportId;
    private Integer defaultChart;
    private String defaultChartName;
    private Integer lineTypeId;
    private Integer periodId;
    private List<GameDTO> gameDTOs = new ArrayList<>();


}
