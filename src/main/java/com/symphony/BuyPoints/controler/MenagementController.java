package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.MenagementDTO;
import com.symphony.BuyPoints.dto.MenagementOutputDTO;
import com.symphony.BuyPoints.service.MenagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menagment")
public class MenagementController {

    private final MenagementService menagementService;

    @GetMapping
    public ResponseEntity<MenagementOutputDTO> getMenagement(@RequestParam(required = true) int sportId, @RequestParam(required = true) int storeId,
                                                             @RequestParam(required = true) int lineTypeId, @RequestParam(required = true) int periodId) {
        return ResponseEntity.ok(menagementService.getMenagement(sportId, storeId, periodId, lineTypeId));
    }

   /* @PostMapping("/default-chart")
    public ResponseEntity createDeafaultChart(@RequestBody DefaultStoreSportChartDTO defaultStoreSportChartDTO) {
        return ResponseEntity.ok(menagementService.createDefaultChart(defaultStoreSportChartDTO));
    }*/

    @PostMapping
    public ResponseEntity saveMenagement(@RequestBody List<MenagementDTO> menagementDTOs) {
        return ResponseEntity.ok(menagementService.createGameChart(menagementDTOs));
    }
}
