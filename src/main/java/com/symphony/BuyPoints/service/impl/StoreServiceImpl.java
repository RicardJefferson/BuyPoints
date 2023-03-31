package com.symphony.BuyPoints.service.impl;

import com.symphony.BuyPoints.model.Store;
import com.symphony.BuyPoints.repository.StoreRepository;
import com.symphony.BuyPoints.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Store> getStores() {
        return storeRepository.findAll();
    }
}
