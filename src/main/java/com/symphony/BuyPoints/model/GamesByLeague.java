/*
package com.symphony.BuyPoints.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

@SqlResultSetMapping(
        name = "gamesByLeagueMapping",
        classes = {
                @ConstructorResult(
                        targetClass = GamesByLeague.class,
                        columns = {
                                @ColumnResult(name = "STORE_ID"),
                                @ColumnResult(name = "SPORT_ID"),
                                @ColumnResult(name = "PERIOD_ID"),
                                @ColumnResult(name = "LINE_TYPE_ID"),
                                @ColumnResult(name = "LEAGUE_ID"),
                                @ColumnResult(name = "NAME"),
                                @ColumnResult(name = "CHART_ID")
                        }
                )
        }
)

@NamedNativeQuery(name = "getGamesByLeague",
        query = "SELECT store_id, l.sport_id, period_id, line_type_id, l.id as league_id, l.name, g.chart_id FROM menagement m " +
                "INNER JOIN league l ON l.id = m.league_id " +
                "INNER JOIN game ON g.menagement_id = m.id " +
                "WHERE m.store_id = :storeId " +
                "AND m.sport_id = :sportId " +
                "AND m.period_id = :period_id " +
                "AND m.line_type_id = :line_type_id ", resultSetMapping = "gamesByLeagueMapping")
@Entity
public class GamesByLeague extends BaseEntity {

    private Integer storeId;
    private Integer sportId;
    private Integer periodId;
    private Integer lineTypeId;
    private Integer leagueId;
    private String leagueName;
    private Integer chartId;

}
*/
