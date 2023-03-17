package com.symphony.BuyPoints.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "chart")
@Entity
public class Chart extends BaseEntity {
    @JsonManagedReference
    @OneToMany(mappedBy = "chart", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    List<ChartItem> items = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "chart", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    List<ChartPointsRatio> chartPointsRatio = new ArrayList<>();

    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "ending_point")
    private double endingPoint;
    @Column(name = "status")
    private boolean status;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "user")
    private String user;

    public void setItems(List<ChartItem> items) {
        if (items != null)
            this.items.addAll(items);
    }

    public void setChartPointsRatio(List<ChartPointsRatio> chartPointsRatio) {
        if (chartPointsRatio != null)
            this.chartPointsRatio.addAll(chartPointsRatio);
    }
}
