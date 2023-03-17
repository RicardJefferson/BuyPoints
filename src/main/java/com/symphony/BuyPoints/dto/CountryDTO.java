package com.symphony.BuyPoints.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CountryDTO {
    private String name;
    private String countryCode;

    private List<LeagueDTO> leagues;

}
