package com.symphony.BuyPoints.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menagement")
@Entity
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "game_type",
        discriminatorType = DiscriminatorType.INTEGER)*/
public class Management extends BaseEntity {

    @JsonManagedReference
    @OneToMany(mappedBy = "menagement", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Game> games = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "default_chart_id", referencedColumnName = "id")
    private DefaultStoreSportChart defaultChart;
    @Column(name = "store_id")
    private Integer storeId;
    @Column(name = "sport_id")
    private Integer sportId;
    @Column(name = "league_id")
    private Integer leagueId;
    @Column(name = "period_id")
    private Integer periodId;
    @Column(name = "line_type_id")
    private Integer lineTypeId;

}
