package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.DefaultStoreSportChart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenagementRepository extends CrudRepository<DefaultStoreSportChart, Integer> {

    Optional<DefaultStoreSportChart> findBySportIdAndStoreId(int sportId, int storeId);

    DefaultStoreSportChart save(DefaultStoreSportChart defaultStoreSportChart);


}
