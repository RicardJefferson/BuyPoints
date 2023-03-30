package com.symphony.BuyPoints.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "management_entity_id", nullable = false)
    private ManagementEntity managementEntity;
    @Column(name = "match_id")
    private Integer matchId;
    @Column(name = "entity_id")
    private Integer entityId;
    @Column(name = "entity_type_id")
    private Integer entityTypeId;
    @Column(name = "store_id")
    private Integer storeId;
    @Column(name = "sport_id")
    private Integer sportId;
    @Column(name = "period_id")
    private Integer periodId;
    @Column(name = "line_type_id")
    private Integer lineTypeId;
    @Column(name = "market_id")
    private Integer marketId;
    @Column(name = "market_name")
    private String marketName;
    @Column(name = "chart_id")
    private Integer chartId;
    @Column(name = "chart_name")
    private String chartName;

}
