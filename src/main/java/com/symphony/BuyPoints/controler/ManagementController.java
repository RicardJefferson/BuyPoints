package com.symphony.BuyPoints.controler;

import com.symphony.BuyPoints.dto.ManagementDTO;
import com.symphony.BuyPoints.dto.ManagementOutputDTO;
import com.symphony.BuyPoints.service.ManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/menagment")
public class ManagementController {

    private final ManagementService managementService;

    @GetMapping
    public ResponseEntity<ManagementOutputDTO> getManagement(@RequestParam(required = true) int sportId, @RequestParam(required = true) int storeId,
                                                             @RequestParam(required = true) int lineTypeId, @RequestParam(required = true) int periodId) {
        return ResponseEntity.ok(managementService.getManagement(sportId, storeId, periodId, lineTypeId));
    }

   /* @PostMapping("/default-chart")
    public ResponseEntity createDeafaultChart(@RequestBody DefaultStoreSportChartDTO defaultStoreSportChartDTO) {
        return ResponseEntity.ok(menagementService.createDefaultChart(defaultStoreSportChartDTO));
    }*/

    @PostMapping
    public ResponseEntity saveManagement(@RequestBody List<ManagementDTO> managementDTOS) {
        return ResponseEntity.ok(managementService.createGameChart(managementDTOS));
    }
}
