package com.symphony.BuyPoints.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CountryDTO {
    private String name;
    private String countryCode;
    @JsonIgnore
    private List<LeagueDTO> leagues;

}
