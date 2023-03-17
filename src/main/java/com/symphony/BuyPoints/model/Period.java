package com.symphony.BuyPoints.model;

import jakarta.persistence.*;
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

   /* @OneToOne(mappedBy = "period")
    private DefaultStoreSportChart wrapper;*/

}
