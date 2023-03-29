package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.EntityChart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityChartRepository extends CrudRepository<EntityChart, Integer> {

/*    @Query("SELECT ec com.symphony.BuyPoints.dto.EntityChartDTO(d.name, e.name, e.email, e.address) "
            + "FROM EntityChart ec INNER JOIN d.entityTypes e")
    List<EntityChartDTO> fetchEmpDeptDataLeftJoin();

    @Query("SELECT e FROM EntityChart e " +
            "WHERE e.storeId = :storeId " +
            "AND e.periodId = :periodId " +
            "AND e.lineTypeId = :lineTypeId " +
            "AND e.sportId = :sportId " +
            "AND e.entity = :lineTypeId " +
            " AND e.sportId = :sportId " )
    Optional<List<EntityChart>> getEntityChart(@Param("sportId") Integer sportId,
                                              @Param("storeId") Integer storeId,
                                              @Param("periodId") Integer periodId,
                                              @Param("lineTypeId") Integer lineTypeId);*/
}
