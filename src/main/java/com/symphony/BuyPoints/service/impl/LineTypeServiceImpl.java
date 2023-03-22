package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.model.LineType;
import com.symphony.BuyPoints.repository.LineTypeRepository;
import com.symphony.BuyPoints.service.LineTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LineTypeServiceImpl implements LineTypeService {

    private final LineTypeRepository lineTypeRepository;

    @Override
    public List<LineType> getAll() {
        return lineTypeRepository.findAllByOrderByIdAsc();
    }
}
