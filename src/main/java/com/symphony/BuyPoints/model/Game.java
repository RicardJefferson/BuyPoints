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

    @Column(name = "league_id")
    private Integer leagueId;

    @Column(name = "league_name")
    private String leagueName;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menagement_id", nullable = false)
    private Management menagement;

}
