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
public interface MatchRepository extends CrudRepository<Match, Integer> {

    Optional<List<Match>> findByMatchIdAndSportIdAndStoreIdAndLineTypeIdAndPeriodId(
            @Param("matchId") Integer matchId,
            @Param("sportId") Integer sportId,
            @Param("storeId") Integer storeId,
            @Param("lineTypeId") Integer lineTypeId,
            @Param("periodId") Integer periodId);

    @Query("delete from Match m where m.matchId = :matchId and m.sportId = :sportId " +
            "and m.storeId = :storeId and m.lineTypeId = :lineTypeId and m.periodId = :periodId ")
    List<Match> deleteExisting(
            @Param("matchId") Integer matchId,
            @Param("sportId") Integer sportId,
            @Param("storeId") Integer storeId,
            @Param("lineTypeId") Integer lineTypeId,
            @Param("periodId") Integer periodId);

}
