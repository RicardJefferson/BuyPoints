package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.EntityChart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntityChartRepository extends CrudRepository<EntityChart, Integer> {

    @Query("SELECT e FROM EntityChart e " +
            "WHERE e.storeId = :storeId " +
            "AND e.periodId = :periodId " +
            "AND e.lineTypeId = :lineTypeId " +
            "AND e.sportId = :sportId " +
            "AND e.entityId = :entityId " +
            "AND e.entityTypeId = :entityTypeId ")
    Optional<List<EntityChart>> getEntityChart(@Param("sportId") Integer sportId,
                                               @Param("storeId") Integer storeId,
                                               @Param("periodId") Integer periodId,
                                               @Param("lineTypeId") Integer lineTypeId,
                                               @Param("entityId") Integer entityId,
                                               @Param("entityTypeId") Integer entityTypeId);

    Optional<List<EntityChart>> findBySportIdAndStoreIdAndLineTypeIdAndPeriodId(
            Integer sportId, Integer storeId, Integer lineTypeId, Integer periodId);
}
