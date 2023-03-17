package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.Chart;
import com.symphony.BuyPoints.model.Sport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SportRepository extends CrudRepository<Sport, Integer> {

    Optional<Sport> findById(int id);

    List<Sport> findAll();


}
