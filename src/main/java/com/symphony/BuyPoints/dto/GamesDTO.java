package com.symphony.BuyPoints.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GamesDTO {
    private Integer lineTypeId;
    private Integer periodId;
    private Integer storeId;
    private Integer leagueId;

    List<GameDTO> gameDTOs = new ArrayList<>();

}
