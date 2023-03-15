package com.symphony.BuyPoints.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@NoArgsConstructor
@Table(name = "chart_points_ratio")
@Entity
public class ChartPointsRatio extends BaseEntity {
    @Column(name = "on_point")
    private int onPoint;
    @Column(name = "on_ratio")
    private int onRatio;
    @Column(name = "off_point")
    private int offPoint;
    @Column(name = "off_ratio")
    private int offRatio;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chart_id", nullable = false)
    private Chart chart;

}