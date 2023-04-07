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
    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "sport_id")
    private Long sportId;

    @Column(name = "chart_id")
    private Long chartId;

    @Column(name = "chart_name")
    private String chartName;

}
