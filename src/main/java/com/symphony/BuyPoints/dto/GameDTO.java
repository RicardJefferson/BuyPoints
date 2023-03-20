package com.symphony.BuyPoints.dto;

import com.symphony.BuyPoints.model.GameType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameDTO {

    private GameType gameType;
    private Integer chartId;

}
