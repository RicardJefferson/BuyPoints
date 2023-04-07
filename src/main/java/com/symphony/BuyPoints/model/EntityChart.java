package com.symphony.BuyPoints.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "entity_chart")
@Entity
public class EntityChart extends BaseEntity {

    @Column(name = "entity_id")
    private Long entityId;
    @Column(name = "entity_type_id")
    private Integer entityTypeId;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "sport_id")
    private Long sportId;
    @Column(name = "period_id")
    private Long periodId;
    @Column(name = "line_type_id")
    private Long lineTypeId;
    @Column(name = "market_id")
    private Long marketId;
    @Column(name = "market_name")
    private String marketName;
    @Column(name = "chart_id")
    private Long chartId;
    @Column(name = "chart_name")
    private String chartName;

}
