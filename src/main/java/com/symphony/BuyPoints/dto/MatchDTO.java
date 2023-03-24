package com.symphony.BuyPoints.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MatchDTO {

    private Integer id;
    private Integer chartId;
    private LocalDateTime date;
    private String homeTeam;
    private String awayTeam;
    private String rotationNumber;


}
