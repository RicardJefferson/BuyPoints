package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.Match;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {

    Optional<List<Match>> findByMatchIdAndSportIdAndStoreIdAndLineTypeIdAndPeriodId(
            @Param("matchId") Long matchId,
            @Param("sportId") Long sportId,
            @Param("storeId") Long storeId,
            @Param("lineTypeId") Long lineTypeId,
            @Param("periodId") Long periodId);

    @Query("delete from Match m where m.matchId = :matchId and m.sportId = :sportId " +
            "and m.storeId = :storeId and m.lineTypeId = :lineTypeId and m.periodId = :periodId ")
    List<Match> deleteExisting(
            @Param("matchId") Long matchId,
            @Param("sportId") Long sportId,
            @Param("storeId") Long storeId,
            @Param("lineTypeId") Long lineTypeId,
            @Param("periodId") Long periodId);

}
