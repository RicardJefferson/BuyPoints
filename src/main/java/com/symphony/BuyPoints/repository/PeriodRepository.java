package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.Period;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodRepository extends CrudRepository<Period, Integer> {

}
