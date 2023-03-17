package com.symphony.BuyPoints.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ChartPointsRatioDTO {

    private int onPoint;
    private int onRatio;
    private int offPoint;
    private int offRatio;

    @JsonIgnore
    private ChartDTO chart;

    public ChartPointsRatioDTO(int onPoint, int onRatio, int offPoint, int offRatio) {
        this.onPoint = onPoint;
        this.onRatio = onRatio;
        this.offPoint = offPoint;
        this.offRatio = offRatio;
    }
}
