package com.symphony.BuyPoints.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Table(name = "sport")
@Entity
public class Sport extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST
                    },
            targetEntity = Period.class)
    @JoinTable(
            name = "sport_period",
            joinColumns = @JoinColumn(name = "sport_id"),
            inverseJoinColumns = @JoinColumn(name = "period_id"))
    @OrderBy("id")
    private Set<Period> sportPeriods;

    @ManyToMany
    @JoinTable(
            name = "sport_market",
            joinColumns = @JoinColumn(name = "sport_id"),
            inverseJoinColumns = @JoinColumn(name = "market_id"))
    @OrderBy("id")
    private Set<Market> markets;

    /*public void removePeriod(Period period) {
        this.sportPeriods.remove(period);
        period.getSports().remove(this);
    }

    public void addPeriod(Period period) {
        this.sportPeriods.add(period);
        period.getSports().add(this);
    }*/

}
