package com.symphony.BuyPoints.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "sport")
@Entity
public class Sport extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "sport_period",
            joinColumns = @JoinColumn(name = "sport_id"),
            inverseJoinColumns = @JoinColumn(name = "period_id"))
    @OrderBy("id")
    private List<Period> sportPeriods;

    @ManyToMany
    @JoinTable(
            name = "sport_market",
            joinColumns = @JoinColumn(name = "sport_id"),
            inverseJoinColumns = @JoinColumn(name = "market_id"))
    @OrderBy("id")
    private List<Market> markets;

}
