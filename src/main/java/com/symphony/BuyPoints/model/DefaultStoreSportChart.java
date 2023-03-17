package com.symphony.BuyPoints.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "store_sport_chart")
@Entity
public class DefaultStoreSportChart extends BaseEntity {

    @Column(name = "line_type_id")
    private Integer lineTypeId;

    @Column(name = "period_id")
    private Integer periodId;

    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "sport_id")
    private Integer sportId;

    @Column(name = "chart_id")
    private Integer chartId;

}
