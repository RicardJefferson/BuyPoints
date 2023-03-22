package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.League;
import com.symphony.BuyPoints.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<League, Integer> {

    @Query("SELECT l FROM League l " +
            "WHERE (:name is null or l.name like :name% ) " +
            "AND (:countryName is null or l.country.name like :countryName% ) " +
            "AND l.sport.id = :sportId ")
    Optional<List<League>> search(@Param("name") String name,
                                  @Param("countryName") String countryName,
                                  @Param("sportId") Integer sportId);


    List<League> findBySport_Id(Integer sportId);


   /* @Query("SELECT l FROM League l " +
            "INNER JOIN  ")
    Optional<List<League>> leagueManagement(@Param("name") String name,
                                  @Param("countryName") String countryName,
                                  @Param("sportId") Integer sportId);*/




}
