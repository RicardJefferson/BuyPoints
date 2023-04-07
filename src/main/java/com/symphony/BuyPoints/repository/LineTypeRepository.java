package com.symphony.BuyPoints.repository;

import com.symphony.BuyPoints.model.LineType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineTypeRepository extends CrudRepository<LineType, Long> {

    List<LineType> findAllByOrderByIdAsc();

}
