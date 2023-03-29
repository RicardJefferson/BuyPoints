package com.symphony.BuyPoints.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "chart_item")
@Entity
public class ChartItem extends BaseEntity {

    @Column(name = "number")
    private int number;

    @NotNull
    @Column(name = "price")
    private int price;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chart_id", nullable = false)
    private Chart chart;



}