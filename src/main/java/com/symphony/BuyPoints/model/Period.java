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

    @ManyToMany(mappedBy = "sportPeriods",
            fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = Sport.class)
    List<Sport> sports;

    @Column(name = "period_name")
    private String periodName;

}
