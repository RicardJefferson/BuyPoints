package com.symphony.BuyPoints.dto;

import com.symphony.BuyPoints.model.ChartItem;
import com.symphony.BuyPoints.model.ChartPointsRatio;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ChartDTO {

    private int id;

    List<ChartItemDTO> items;

    List<ChartPointsRatioDTO> chartPointsRatio;

    private String name;

    private double endingPoint;

    private Boolean status;

    private String user;

    public ChartDTO(int id, List<ChartItemDTO> items, List<ChartPointsRatioDTO> chartPointsRatio, String name, double endingPoint) {
        this.id = id;
        this.items = items;
        this.chartPointsRatio = chartPointsRatio;
        this.name = name;
        this.endingPoint = endingPoint;
    }
}
