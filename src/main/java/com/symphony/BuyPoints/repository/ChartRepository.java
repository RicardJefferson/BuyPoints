package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.Chart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChartRepository extends CrudRepository<Chart, Long> {

    List<Chart> findAll();
    List<Chart> findByStatusTrue();

    Optional<Chart> findByName(String name);
    Optional<Chart> findById(long id);

    Chart save(Chart chart);

   /* List<Chart> find(int sportId);*/


}
