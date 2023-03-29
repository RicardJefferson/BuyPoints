package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.dto.EntityChartDTO;
import com.symphony.BuyPoints.model.ManagementEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagementEntityRepository extends CrudRepository<ManagementEntity, Integer> {

    @Query("SELECT new com.symphony.BuyPoints.dto.EntityChartDTO(e.entityId,ec.entityTypeId, " +
            "e.displayName, e.organizationName, ec.marketId, ec.marketName, " +
            "ec.chartId, ec.chartName ) " +
            "FROM ManagementEntity e , EntityChart ec " +
            "WHERE e.entityId = ec.entityId " +
            "AND ec.entityTypeId = ec.entityTypeId " +
            "AND ec.storeId = :storeId " +
            "AND ec.periodId = :periodId " +
            "AND ec.lineTypeId = :lineTypeId " +
            "AND ec.sportId = :sportId ")
    List<EntityChartDTO> getEntities(@Param("sportId") Integer sportId,
                                     @Param("storeId") Integer storeId,
                                     @Param("periodId") Integer periodId,
                                     @Param("lineTypeId") Integer lineTypeId);

    List<ManagementEntity> findBySport_Id(int sportId);

 /*   Query("SELECT l FROM League l " +
                  "WHERE (:name is null or l.name like :name% ) " +
                  "AND (:countryName is null or l.country.name like :countryName% ) " +
                  "AND l.sport.id = :sportId ")
    Optional<List<League>> search(@Param("name") String name,
                                  @Param("countryName") String countryName,
                                  @Param("sportId") Integer sportId);*/

}
