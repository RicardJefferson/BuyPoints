package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.Menagement;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenagementRepository extends CrudRepository<Menagement, Integer> {

    @Query("SELECT m FROM Menagement m " +
        "INNER JOIN m.games g " +
        "WHERE m.storeId = :storeId " +
        "AND m.periodId = :periodId " +
        "AND m.lineTypeId = :lineTypeId " +
        "AND m.sportId = :sportId ")
Optional<List<Menagement>> getLeagueGames(@Param("sportId") Integer sportId,
                                          @Param("storeId") Integer storeId,
                                          @Param("periodId") Integer periodId,
                                          @Param("lineTypeId") Integer lineTypeId);

}
