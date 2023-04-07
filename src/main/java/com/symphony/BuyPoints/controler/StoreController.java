package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.model.Store;
import com.symphony.BuyPoints.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public ResponseEntity<List<Store>> getChartById() {
        return ResponseEntity.ok(storeService.getStores());
    }
}
