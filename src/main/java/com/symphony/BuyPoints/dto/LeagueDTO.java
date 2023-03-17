package com.symphony.BuyPoints.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeagueDTO {

    private Integer id;
    private String name;
    private CountryDTO countryDTO;

}
