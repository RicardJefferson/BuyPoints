package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.dto.EntityChartDTO;
import com.symphony.BuyPoints.model.ManagementEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ManagementEntityRepository extends PagingAndSortingRepository<ManagementEntity, Long> {

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
    List<EntityChartDTO> getEntities(@Param("sportId") Long sportId,
                                     @Param("storeId") Long storeId,
                                     @Param("periodId") Long periodId,
                                     @Param("lineTypeId") Long lineTypeId);

    List<ManagementEntity> findBySport_Id(long sportId);

    ManagementEntity findByEntityId(long entityId);

    @Query("SELECT e FROM ManagementEntity e " +
            "WHERE (:displayName is null or e.displayName like :displayName% ) " +
            "AND (:organizationName is null or e.organizationName like :organizationName% ) ")
    Optional<Page<ManagementEntity>> search(@Param("displayName") String displayName,
                                            @Param("organizationName") String organizationName,
                                            Pageable pageable);

    /*Page<ManagementEntity> findAllByDisplayNameStartsWithAndOrganizationNameStartsWith(
            String displayName,
            String organizationName,
            Pageable pageable);*/

}
