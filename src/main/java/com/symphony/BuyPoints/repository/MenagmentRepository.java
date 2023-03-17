package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.DefaultStoreSportChart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenagmentRepository extends CrudRepository<DefaultStoreSportChart, Integer> {

    Optional<DefaultStoreSportChart> findBySportIdAndStoreId(int sportId, int storeId);

    Optional<DefaultStoreSportChart> findBySportIdAndStoreIdAndLineTypeIdAndPeriodId
            (Integer sportId, Integer storeId, Integer lineTypeId, Integer periodId);

    DefaultStoreSportChart save(DefaultStoreSportChart defaultStoreSportChart);


}
