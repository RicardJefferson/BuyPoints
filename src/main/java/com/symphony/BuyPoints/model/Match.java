package com.symphony.BuyPoints.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "match_chart")
@Entity
public class Match extends BaseEntity {
    @Column(name = "match_id")
    private Long matchId;
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
