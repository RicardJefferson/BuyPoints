package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends CrudRepository<Match, Integer> {

    Optional<List<Match>> findByRotationNumber(Integer id);

}
