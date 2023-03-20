package com.symphony.BuyPoints.model;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity(name = "game")
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "game_type",
        discriminatorType = DiscriminatorType.INTEGER)*/
public class Game extends BaseEntity {

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "game_type")
    private GameType gameType;

    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "league_id")
    private Integer leagueId;

    @Column(name = "chart_id")
    private Integer chartId;

    @Column(name = "period_id")
    private Integer periodId;

    @Column(name = "line_type_id")
    private Integer lineTypeId;

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "league_id", referencedColumnName = "id")
    private League league;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "line_type_id", referencedColumnName = "id")
    private LineType lineType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "period_id", referencedColumnName = "id")
    private Period period;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chart_id", referencedColumnName = "id")
    private Chart chart;*/




    /*@JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "league_id", nullable = false)
    private League league;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "league_id", nullable = false)
    private League league;*/


}
