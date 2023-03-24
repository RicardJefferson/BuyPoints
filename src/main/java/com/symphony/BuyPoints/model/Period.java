package com.symphony.BuyPoints.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Table(name = "period")
@Entity
public class Period extends BaseEntity {

    @ManyToMany(mappedBy = "sportPeriods")
    List<Sport> sports;

    @Column(name = "period_name")
    private String periodName;

}
