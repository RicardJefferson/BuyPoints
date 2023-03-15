package com.symphony.BuyPoints.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChartItemDTO {

    private int number;
    private int price;

    @JsonIgnore
    private ChartDTO chart;

    public ChartItemDTO(int number, int price) {
        this.number = number;
        this.price = price;
    }
}
