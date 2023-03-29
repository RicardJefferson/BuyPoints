package com.symphony.BuyPoints.dto;

import com.symphony.BuyPoints.model.Period;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SportDTO {
    private int id;
    private String name;
    private List<PeriodDTO> sportPeriods;
    private List<MarketDTO> marketDTOs;
}
