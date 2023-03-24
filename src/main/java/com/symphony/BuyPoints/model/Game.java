package com.symphony.BuyPoints.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "game")
@Entity
public class Game extends BaseEntity {

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "game_type")
    private GameType gameType;
    @Column(name = "chart_id")
    private Integer chartId;
    @Column(name = "chart_name")
    private String chartName;
 /*   @Column(name = "league_name")
    private String leagueName;
    @Column(name = "league_id")
    private Integer leagueId;*/

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "league_id", nullable = false)
    private League league;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menagement_id", nullable = false)
    private Management menagement;

}
