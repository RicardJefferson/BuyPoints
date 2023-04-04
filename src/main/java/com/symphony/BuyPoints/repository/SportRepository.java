package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.Sport;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SportRepository extends CrudRepository<Sport, Integer> {

    Optional<Sport> findById(int id);

    List<Sport> findAll();

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM sport_period sp WHERE sp.sport_id = ?", nativeQuery = true)
    Object removeSportPeriodsRelations(int id);
}
