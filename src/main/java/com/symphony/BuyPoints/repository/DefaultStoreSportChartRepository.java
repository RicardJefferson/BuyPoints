package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.DefaultStoreSportChart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DefaultStoreSportChartRepository extends CrudRepository<DefaultStoreSportChart, Long> {

    Optional<DefaultStoreSportChart> findBySportIdAndStoreId(long sportId, long storeId);

    DefaultStoreSportChart save(DefaultStoreSportChart defaultStoreSportChart);


}
