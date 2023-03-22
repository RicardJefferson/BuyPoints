package com.symphony.BuyPoints.dto;

import com.symphony.BuyPoints.model.LineType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MenagementOutputDTO {

    private DefaultStoreSportChartDTO defaultChart;

    private List<LeagueOutputDTO> leagueOutputDTO;

}
