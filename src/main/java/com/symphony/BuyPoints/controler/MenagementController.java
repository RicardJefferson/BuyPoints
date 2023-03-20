package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.DefaultStoreSportChartDTO;
import com.symphony.BuyPoints.dto.GamesDTO;
import com.symphony.BuyPoints.service.MenagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menagment")
public class MenagementController {

    private final MenagementService menagementService;

    @GetMapping
    public ResponseEntity<DefaultStoreSportChartDTO> getActiveCharts(@RequestParam(required = true) int sportId, @RequestParam(required = true) int storeId) {
        return ResponseEntity.ok(menagementService.getDefaultChart(sportId, storeId));
    }

    @PostMapping("/default-chart")
    public ResponseEntity createDeafaultChart(@RequestBody DefaultStoreSportChartDTO defaultStoreSportChartDTO) {
        return ResponseEntity.ok(menagementService.createDefaultChart(defaultStoreSportChartDTO));
    }

    @PostMapping("/game-chart")
    public ResponseEntity createGameChart(@RequestBody GamesDTO gamesDTO) {
        return ResponseEntity.ok(menagementService.createGameChart(gamesDTO));
    }
}
