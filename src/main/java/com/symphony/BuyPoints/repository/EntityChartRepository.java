package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.EntityChart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntityChartRepository extends CrudRepository<EntityChart, Long> {

    @Query("SELECT e FROM EntityChart e " +
            "WHERE e.storeId = :storeId " +
            "AND e.periodId = :periodId " +
            "AND e.lineTypeId = :lineTypeId " +
            "AND e.sportId = :sportId " +
            "AND e.entityId = :entityId " +
            "AND e.entityTypeId = :entityTypeId ")
    Optional<List<EntityChart>> getEntityChart(@Param("sportId") Long sportId,
                                               @Param("storeId") Long storeId,
                                               @Param("periodId") Long periodId,
                                               @Param("lineTypeId") Long lineTypeId,
                                               @Param("entityId") Long entityId,
                                               @Param("entityTypeId") Integer entityTypeId);

    Optional<List<EntityChart>> findBySportIdAndStoreIdAndLineTypeIdAndPeriodId(
            Long sportId, Long storeId, Long lineTypeId, Long periodId);
}
