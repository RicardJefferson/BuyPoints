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
public class LeagueOutputDTO {

    private Integer id;
    private String leagueName;
    /*private CountryDTO countryDTO;*/

    private String countryName;
    private List<GameDTO> games;
}
